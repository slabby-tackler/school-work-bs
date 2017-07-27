module InterestCalculator (calculate) where
import Helper

calculate = do
	putStrLn("How much is the deposit? ")
	tmp <- getLine
	let deposit = conDouble tmp
	putStrLn("What is the percent yearly interest? ")
	tmp <- getLine
	let interest = conDouble tmp
	putStrLn("What is the term? ")
	tmp <- getLine
	let years = conDouble tmp
	let earned = calcIntEarned deposit interest years
	let final = calcFinal deposit earned
	putStr("Amount of interest earned: ")
	print earned
	putStr("Final total: ")
	print final
	tmp <- getLine
	print()
	
calcIntEarned deposit int period = (deposit * (((conPer int) + 1.0) ** period)) - deposit

calcFinal dep earn = dep + earn
