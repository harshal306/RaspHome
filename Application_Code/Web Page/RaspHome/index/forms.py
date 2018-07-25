from django import forms

class LoginForm(forms.Form):
   email = forms.CharField(label = 'email', max_length = 100)
   pswd = forms.CharField(label = 'pswd', widget = forms.PasswordInput())
   api = []
   def formView(request):
      if request.session.has_key('email') and request.session.has_key('pswd'):
         email = request.session['email']
         pswd = request.session['pswd']
         api = request.session['api']
         return render(request, "RaspHome/login_action.html", {"credentials": [email, pswd, api]})
      else:
         return render(request, "RaspHome/index.html")
