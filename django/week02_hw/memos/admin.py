from django.contrib import admin

from .models import Memo
from .models import Comment

admin.site.register(Memo)
admin.site.register(Comment)

