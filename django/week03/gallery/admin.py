from django.contrib import admin
from .models import Image, ImageComment

# Register your models here.

class ImageCommentInline(admin.TabularInline):
    model = ImageComment
    extra = 0
    min_num = 1
    max_num = 5
    verbose_name = '댓글'
    verbose_name_plural = '댓글들'
@admin.register(Image)
class ImageModelAdmin(admin.ModelAdmin):
    list_display = ['id', 'content', 'created_at']
    list_editable = ['content']
    list_filter = ['created_at']
    search_fields = ['id', 'content']
    search_help_text = '이미지 번호와 내용을 검색할 수 있습니다.'
    inlines = [ImageCommentInline]
    actions = ['report']

    def report(self, request, queryset):
        for item in queryset:
            item.content = '운영규칙 위반 이미지 삭제'
            item.save()
