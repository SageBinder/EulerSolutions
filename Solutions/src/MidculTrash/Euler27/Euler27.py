def prime(n):
    if abs(n) < 2:
        return False
    if abs(n) == 2:
        return True
    for x in range(2, int(abs(n)**0.5)+1):
        if n % x == 0:
            return False
    return True

streak, best, besta, bestb = 0, 0, 0, 0
for a in range(-999, 1000):
    print(a)
    for b in range(-1000, 1001):
        streak = 0
        for c in range(100000):
            num = (c**2) + (a*c) + b
            if prime(num):
                streak += 1
            else:
                if streak > best:
                    best = streak
                    besta = a
                    bestb = b
                break
print(besta*bestb)
