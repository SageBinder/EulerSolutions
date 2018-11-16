def is_prime(n):
  if n == 2 or n == 3: return True
  if n < 2 or n%2 == 0: return False
  if n < 9: return True
  if n%3 == 0: return False
  r = int(n**0.5)
  f = 5
  while f <= r:
    print('\t',f)
    if n%f == 0: return False
    if n%(f+2) == 0: return False
    f +=6
  return True    


import math

lastprime = 1

for i in range(int(round(math.sqrt(600851475143 ))) + 1):
    if i == 0:
        continue
    if 600851475143  % i == 0 and is_prime(i):
        lastprime = i
print(lastprime)
