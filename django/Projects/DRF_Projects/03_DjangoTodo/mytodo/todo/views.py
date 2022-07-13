import django.core.handlers.wsgi
from django.shortcuts import render , redirect

from todo.models import Todo
from .forms import TodoForm


# Create your views here.


def todo_list(request: django.core.handlers.wsgi.WSGIRequest):
    """
    Todo 데이터를 템플릿으로 넘겨주는 기능을 갖고 있습니다.
    이때 완료되지 않은 Todo만 전달 해야 하기 때문에 complete=False 옵션으로 필터링 해야 합니다.
    필터링은 Todo.objects.filter로 처리할 수 있으며, todo_list 뷰는 아래와 같이 작성할 수 있다.

    :param request: django request 요청 객체
    :return:
    """
    todos = Todo.objects.filter(complete=False)
    return render(request=request ,
                  template_name="todo/todo_list.html" ,
                  context={
                      "todos": todos
                  })


def todo_detail(request: django.core.handlers.wsgi.WSGIRequest , pk: int):
    """
    Todo의 pk인 id를 기반으로 Todo 객체를 찾아 todo_detial.html로 전달할 수 있도록 작성한다
    :param request: django request 요청 객체
    :param pk: Todo 목록에서 열람한 Todo의 pk 값
    :return:
    """
    todo = Todo.objects.get(id=pk)
    return render(request=request , template_name="todo/todo_detail.html" , context={
        "todo": todo
    })


def todo_post(request: django.core.handlers.wsgi.WSGIRequest):
    method: str = request.method
    form = TodoForm()
    if method == "POST":
        form = TodoForm(method)
        if form.is_valid():
            todo = form.save(commit=False)
            todo.save()
            return redirect(to="todo_list")
    return render(
        request=request ,
        template_name="todo/todo_post.html" ,
        content_type={
            "form": form
        })


"""
Todo 수정뷰 만들기
기존 Todo 데이터를 전달해서 Form에 셋팅해줘야 한다
"""


def todo_edit(request: django.core.handlers.wsgi.WSGIRequest , pk: int):
    """
    :param request: django 연결 객체
    :param pk: 수정하려는 todo의 edit pk 값
    :return:
    """
    todo = Todo.objects.get(id=pk)
    print(todo)
    print(type(todo))

    method: str = request.method
    form = TodoForm(todo)

    if todo is not None and request.method == "POST":
        form = TodoForm(data=request.POST , instance=todo)
        if form.is_valid():
            todo = form.save(commit=False)  # 수정하려는 todo 폼을 가져온다
            todo.save()

            # 수정 완료 후 todo_list 페이지로 이동한다
            return redirect(to="todo_list")

    return render(request=request ,
                  template_name="todo/todo_post.html" ,
                  context={
                      "form": form
                  })
