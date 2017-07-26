module Helper (conPer, conDouble, conInteger) where
import Data.Ratio

conPer v = v / 100

conDouble s = read s :: Double

conInteger s = read s :: Integer
