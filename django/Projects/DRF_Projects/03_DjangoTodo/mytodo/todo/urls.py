from django.urls import path

from . import views

urlpatterns = [
    path("" , views.todo_list , name="todo_list") ,  # Todo 전체 조회 URL 연결
    path("<int:pk>" , views.todo_detail , name="todo_detail") ,  # Todo 상세조회 URL 연결
    path("post/" , views.todo_post , name="todo_post") ,  # Todo 생성 URL 연결
    path("<int:pk>/edit/" , views.todo_edit , name="todo_edit")  # Todo 수정 URL 연결
]
