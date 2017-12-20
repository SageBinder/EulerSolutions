def is_prime(n):
  if n == 2 or n == 3: return True
  if n < 2 or n%2 == 0: return False
  if n < 9: return True
  if n%3 == 0: return False
  r = int(n**0.5)
  f = 5
  while f <= r:
    if n%f == 0: return False
    if n%(f+2) == 0: return False
    f +=6
  return True

i = 0
primeCounter = 0
while True:
    print("Checking %d" % (i))
    if is_prime(i):
        primeCounter += 1
    if primeCounter == 10001:
        print("Found: %d" % (i))
        break
    i += 1
