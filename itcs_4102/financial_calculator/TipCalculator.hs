module TipCalculator (calculate) where
import Helper

calculate = do
	putStrLn("How much is the bill?")
	tmp <- getLine
	let bill = conDouble tmp
	putStrLn("What percent is tax?")
	tmp <- getLine
	let tax = conDouble tmp
	putStrLn("How many people are splitting the bill?")
	tmp <- getLine
	let people = conDouble tmp
	putStrLn("What percent do you want to tip?")
	tmp <- getLine
	let tip = conDouble tmp
	let tip_amount = amtTip (grossBill bill (amtTax bill tax)) tip
	let final_bill = finalBill (grossBill bill (amtTax bill tax)) tip_amount
	let per_person = tipPerPerson tip_amount people
	putStr("Final bill total: ")
	print final_bill
	putStr("Tip amount: ")
	print tip_amount
	putStr("Tip per person: ")
	print per_person
	tmp <- getLine
	print()
		
amtTax bill tax = bill * (conPer tax)

grossBill bill taxVal = taxVal + bill

amtTip bill tip = bill * (conPer tip)

tipPerPerson tipAmt numPeople = tipAmt / numPeople

finalBill gross tip = gross + tip
