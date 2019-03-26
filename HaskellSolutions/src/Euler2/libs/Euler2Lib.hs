module Euler2Lib(fibSum) where
  fibSum a b max = if((a + b) > max) then 0 else fibSum b (a + b) max + if((a + b) `mod` 2 == 0) then (a + b) else 0
