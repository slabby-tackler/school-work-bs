module Credit.CreditHelper (run) where
import qualified Credit.MonthlyPaymentCalculator as Month
import qualified Credit.MonthsLeft as Payment

run = do
	printChoices
	choice <- getLine
	case choice of
		"1" -> Month.calculate
		"2" -> Payment.calculate
		_ -> putStrLn("That feature has not been implemented")
	
printChoices = do
	putStrLn("1. Calculate payment needed to pay off loan")
	putStrLn("2. Calculate how many months until you're debt free")
