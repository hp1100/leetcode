# -*- coding: utf-8 -*-
def main():

    f1 = open("house_items.json")
    data = [0 for i in range(12)]
    rsum = [0 for i in range(12)]
    ravg = [0 for i in range(12)]
    for line in f1:
        #get price
        beg = line.find("\"price\":")
        end = line.find(", \"bathroom")
        if beg == -1 or end == -1:
            continue
        price = int(line[beg+9:end])
        #get bedrooms num
        beg = line.find("\"bedroom\": ")
        end = line.find(", \"latitude")
        if beg == -1 or end == -1:
            continue
        room_num = line[beg+11:end]
        if room_num == 'null' or room_num == '0.0':
            continue
        else:
            room_num = int(float(room_num))
        #get beathrooms num
        beg = line.find("\"bathroom\": ")
        end = line.find(", \"longitude")
        if beg == -1 or end == -1:
            continue
        bath_num = line[beg+12:end]
        if bath_num == 'null' or bath_num == '0.0':
            continue
        else:
            bath_num = int(float(bath_num))
        #what kind of room
        if room_num == 1 and bath_num == 1:#1B1B
            data[0] += 1
            rsum[0] += price
        elif room_num == 2 and bath_num == 1:#2B1B
            data[1] += 1
            rsum[1] += price
        elif room_num == 2 and bath_num == 2:#2B2B
            data[2] += 1
            rsum[2] += price
        elif room_num == 3 and bath_num == 1:#3B1B
            data[3] += 1
            rsum[3] += price
        elif room_num == 3 and bath_num == 2:#3B2B
            data[4] += 1
            rsum[4] += price
        elif room_num == 3 and bath_num == 3:#3B3B
            data[5] += 1
            rsum[5] += price
        elif room_num == 4 and bath_num == 1:#4B1B
            data[6] += 1
            rsum[6] += price
        elif room_num == 4 and bath_num == 2:#4B2B
            data[7] += 1
            rsum[7] += price
        elif room_num == 4 and bath_num == 4:#4B4B
            data[8] += 1
            rsum[8] += price
        elif room_num == 5 and bath_num == 2:#5B2B
            data[9] += 1
            rsum[9] += price
        elif room_num == 5 and bath_num == 3:#5B3B
            data[10] += 1
            rsum[10] += price
        else:
            print(str(room_num)+"B"+str(bath_num)+"B:"+str(price))
            data[-1] += 1
    f1.close()
    for i in range(len(ravg)):
        ravg[i] = int(rsum[i]/data[i])
    f2 = open("room_type.txt",'w')
    for i in range(len(data)):
        f2.write(str(data[i])+","+str(ravg[i])+"\n")
    f2.close()

if __name__ == "__main__":
    main()
