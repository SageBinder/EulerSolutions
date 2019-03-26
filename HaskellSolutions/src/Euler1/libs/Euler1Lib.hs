module Euler1Lib(mySum) where
  mySum n = if n == 1 then 0 else mySum(n - 1) + if n `mod` 3 == 0 || n `mod` 5 == 0 then n else 0
