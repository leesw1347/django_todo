from django.contrib import admin

# 관리자 페이지에서 todo 앱을 확인할 수 있도록 등록한다
from todo.models import Todo

# Register your models here.

admin.site.register(Todo)

