
from datetime import timedelta as t
from datetime import datetime as d

def gi(hours):
    for k in range(2, hours+ 1):
        if prime_function(k):
            pre.append(k)

def prime_function(hours):
    if hours<= 1 :
        return False
    for k in range(2, hours):
        if hours % k == 0:
            return False
    return True
Dyear, Dweek, hours= input().split()
hours= int(hours)
pre=[]
gi(365)
dadic={0:"Mon", 1:"Tue", 2:"Wed", 3:"Thu", 4:"Fri", 5:"Sat", 6:"Sun"}
Dyear=d.strptime(Dyear, "%Y%m%d")
das=-1
for k in pre:
    dte= Dyear + t(k)
    if prime_function(dte.month) and dadic[dte.weekday()]==Dweek:
        das=k
        break
if das==-1:
    print("No", 0,end="")
elif das<=hours:
    print("Yes", das,end="")
else:
    print("No", das,end="")