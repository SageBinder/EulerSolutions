import math


def is_square(apositiveint):
    x = apositiveint // 2
    seen = {x}
    while x * x != apositiveint:
        x = (x + (apositiveint // x)) // 2
        if x in seen: return False
        seen.add(x)
    return True


aa = 0
bb = 0
cc = 0
breakOutLoop = False
for a in range(1, 1000):
    for b in range(a, 1000):
        cc = (a ** 2) + (b ** 2)
        if is_square(cc) and (a + b + math.sqrt(cc) == 1000):
            aa = a
            bb = b
            breakOutLoop = True
            break
    if breakOutLoop:
        break
print("%d, %d, %d" % (aa, bb, math.sqrt(cc)))
print("Product: %d" % (aa * bb * math.sqrt(cc)))
