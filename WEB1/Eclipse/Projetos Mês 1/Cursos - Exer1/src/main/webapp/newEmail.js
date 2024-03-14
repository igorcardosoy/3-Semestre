let addEmail = document.getElementById('addEmail')
let removeEmail = document.getElementById('removeEmail')

addEmail.addEventListener('click', function() {
	let div = document.createElement('div')
	div.className = 'email-div'
	
	let label = document.createElement('label')
	label.innerHTML = 'Outro e-mail:'
	label.htmlFor = 'emails'
	
	div.appendChild(label)
	
	let email = document.createElement('input')
	email.type = 'email'
	email.name = 'emails'
	email.className = 'form-control'
	email.placeholder = 'Email'
	
	div.appendChild(email)
	
	document.getElementById('emails').appendChild(div)
})

removeEmail.addEventListener('click', function() {
	let emails = document.getElementById('emails')
	let emailDivs = emails.getElementsByClassName('email-div')

	if (emailDivs.length >= 1) {
		emails.removeChild(emailDivs[emailDivs.length - 1])
	}
	
	
})