from django.contrib import admin
from .models import Post, Comment

# Register your models here.

class CommentInline(admin.TabularInline):
    model = Comment
    extra = 0
    min_num = 1
    max_num = 5
    verbose_name = '댓글'
    verbose_name_plural = '댓글'
@admin.register(Post)
class PostModelAdmin(admin.ModelAdmin):
    list_display = ['id', 'content', 'created_at', 'view_count']
    list_editable = ['content', 'view_count']
    list_filter = ['created_at']
    search_fields = ['id', 'content']
    search_help_text = '게시글 번호와 내용을 검색할 수 있습니다.'
    inlines = [CommentInline]
    actions = ['report']

    def report(self, request, queryset):
        for item in queryset:
            item.content = '운영규칙 위반 게시글 삭제'
            item.save()