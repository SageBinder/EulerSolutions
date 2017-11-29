def prime(n):
    if abs(n) < 2:
        return False
    if abs(n) == 2:
        return True
    for x in range(2, int(abs(n)**0.5)+1):
        if n % x == 0:
            return False
    return True


def check(num1, num2):
    for d in range(num1+1, num2):
        if prime(d):
            return True

streak, best, besta, bestb = 0, 0, 0, 0
for a in range(-999, 1000):
    print(a)
    for b in range(-1000, 1001):
        for c in range(100000):
            num1 = c**2 + a*c + b
            num2 = (c+1)**2 + a*(c+1) + b
            if prime(num1) and prime(num2) and num2 > num1:
                if check(num1, num2):
                    if streak > best:
                        best = streak
                        besta = a
                        bestb = b
                        streak = 0
                    break
                else:
                    streak += 1
            else:
                if streak > best:
                    best = streak
                    besta = a
                    bestb = b
                    streak = 0
                break

print(besta*bestb)
