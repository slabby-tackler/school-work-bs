module Credit.MonthlyPaymentCalculator (calculate) where
import Helper

calculate = do
	putStrLn("How much do you still owe?")
	tmp <- getLine
	let credit = conDouble tmp
	putStrLn("What is the monthly interest rate?")
	tmp <- getLine
	let interest = conPer (conDouble tmp)
	putStrLn("In how many months would you like to pay it off in?")
	tmp <- getLine
	let months = conDouble tmp
	let payment = findPayment credit interest months
	print(interest)
	putStr("Payment per month: ")
	print(payment)
	tmp <- getLine
	print()
	
findPayment credit interest months = credit / (interestCalc interest months)

interestCalc interest months = (1 - ((1.0 + interest) ** (months * (-1.0)))) / interest
