module Main (main) where
-- Files for import --
import qualified TipCalculator
import qualified InterestCalculator
import qualified Credit.CreditHelper as CreditHelper
import qualified GradePointAverage

main = do 
	putStrLn("Please select one:")
	displayOptions
	choice <- getLine
	case choice of
		"1" -> TipCalculator.calculate
		"2" -> InterestCalculator.calculate
		"3" -> CreditHelper.run
		"4" -> GradePointAverage.calculate
		_ -> putStrLn("That feature has not been implemented")

displayOptions = do
	putStrLn("1. Tip calculator")
	putStrLn("2. Interest calculator")
	putStrLn("3. Credit Payoff calculator")
	putStrLn("4. GPA Calculation")
