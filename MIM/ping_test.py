from scapy.all import *

p =Ether()/IP(dst="10.10.10.2", src="10.10.10.4")/ICMP()

send = srp(p)


p.show()

