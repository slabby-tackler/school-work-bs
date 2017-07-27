module Credit.MonthsLeft (calculate) where
import Helper

calculate = do
	putStrLn("How much is still owed?")
	tmp <- getLine
	let credit = conDouble tmp
	putStrLn("What is the monthly interst?")
	tmp <- getLine
	let interest = conPer (conDouble tmp)
	putStrLn("What will be the payment?")
	tmp <- getLine
	let payment = conDouble tmp
	let months = findMonths credit interest payment 0
	putStr("Number of months to pay off: ")
	print(months)
	tmp <- getLine
	print()
	
findMonths credit interest payment months =
	if credit <= 0
		then months
		else
			findMonths ((credit - payment) * (1.0 + interest)) interest payment (months + 1)
