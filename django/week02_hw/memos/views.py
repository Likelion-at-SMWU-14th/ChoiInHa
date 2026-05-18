from django.shortcuts import render
from django.views.generic import DetailView
from .models import Memo

# FBV: 메모 목록 보기
def memo_list(request):
    memos = Memo.objects.all().order_by('-created_at')

    return render(request, 'memo/memo_list.html', {
        'memos': memos
    })


# CBV: 메모 상세 보기
class MemoDetailView(DetailView):
    model = Memo
    template_name = 'memo/memo_detail.html'
    context_object_name = 'memo'