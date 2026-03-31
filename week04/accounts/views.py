from django.shortcuts import render, redirect
from .forms import SignUpForm

# Create your views here.
def signup(request):
    if request.method == "POST":
        form = SignUpForm(request.POST)
        if form.is_valid():
            form.save()
            return redirect('login')
        else: 
            print(form.errors)
    else:
        form = SignUpForm()

    return render(request, 'signup.html', {'form': form})