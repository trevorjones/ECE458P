from scapy.all import *
from subprocess import call
import os

#sniff(iface="eth0", prn=lambda x: x.show())

myMAC = "c0:3f:d5:61:7d:8b"

def fwd(x):  
    if(x[Ether].src != myMAC):
        with open('/proc/net/arp', 'r') as mac_file:
            mac_list = mac_file.read().splitlines()

            iter_macs = iter(mac_list)
            next(iter_macs)
            mac_matrix = []
            for macs in iter_macs:
                mac_matrix.append(macs.split())
            
        for mac_list in mac_matrix:
            if(x[IP].dst == mac_list[0]):
                x[Ether].dst = mac_list[3]
                #print mac_matrix
        x[Ether].src = myMAC

        print("AFTER===========================") 
        print x.show()
        sendp(x)

#Sniff traffic on ethernet0 interface
#Filter ICMP requests
#Pass result to function fwd
sniff(filter="icmp", iface="eth0", prn=lambda x: fwd(x))

