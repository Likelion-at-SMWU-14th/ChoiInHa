from django.db import models
from django.contrib.auth import get_user_model

# Create your models here.
User = get_user_model()

class Memo(models.Model):
    writer = models.ForeignKey(User, verbose_name='작성자', on_delete=models.CASCADE, null=True, blank=True)
    content = models.TextField(verbose_name='내용')
    created_at = models.DateTimeField(verbose_name='작성일', auto_now_add=True)

class Comment(models.Model):
    memo = models.ForeignKey(Memo, verbose_name='메모', on_delete=models.CASCADE)
    writer = models.ForeignKey(User, verbose_name='작성자', on_delete=models.CASCADE, null=True, blank=True)
    content = models.TextField(verbose_name='내용')
    created_at = models.DateTimeField(verbose_name='작성일', auto_now_add=True)