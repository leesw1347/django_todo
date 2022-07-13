# Todo 생성기능 컨셉
from django import forms

from .models import Todo


class TodoForm(forms.ModelForm):
    class Meta:
        model = Todo
        fields = (
            "title" ,
            "description" ,
            "important"
        )
