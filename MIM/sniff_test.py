from scapy.all import *


sniff(filter="icmp", iface="eth0", prn=lambda x: x.show())
