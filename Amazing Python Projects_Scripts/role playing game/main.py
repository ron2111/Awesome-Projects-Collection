from game import Person,bcolors
from magic import Spell
from inventory import Item
import random


##Black Magic
fire = Spell("Fire", 25, 600, "black")
thunder = Spell("Thunder", 25, 600, "black")
ice = Spell("Ice", 25, 600, "black")
meteor = Spell("Fire", 40, 1200, "black")
quake = Spell("Quake", 14, 140, "black")

##White Magic1
cure = Spell("Cure", 25, 620, "white")
cura = Spell("Cura", 32, 1500, "white")
curaga = Spell("Curaga",50,6000,"white")

##Create some items
potion = Item("Potion","potion","Heals 50 HP",50)
hipotion = Item("Hi-Potion","potion","Heals for 100 HP",100)
superpotion = Item("Super Potion","potion","Heals for 1000 HP",1000)
elixer = Item("Elixer","elixer","Fully restores HP/MP of one member",9999)
hielixer = Item("Mega Elixer","elixer","Fully restores HP/MP of both of them",9999)

grenade = Item("Grenade","attack","Deals 100 Damage",100)
bomb = Item("Bomb","attack","Deals with 500 Damage",500)

player_spells = [fire,thunder,ice,meteor,quake,cure,cura]
enemy_spells = [fire,meteor,curaga]
player_items = [{"item": potion, "quantity": 15},
                {"item": hipotion, "quantity": 5},
                {"item": superpotion, "quantity": 5},
                {"item": elixer, "quantity": 5},
                {"item": hielixer, "quantity": 2},
                {"item": grenade,"quantity":5},
                {"item":bomb,"quantity":5}]

player1 = Person("Parth ", 3260, 132, 300, 34, player_spells, player_items)
player2 = Person("Stark ", 4160, 188, 311, 34, player_spells, player_items)
player3 = Person("Steve ", 3089, 174, 288, 34, player_spells, player_items)

enemy1 = Person("Ronan ", 1250, 130, 560, 325, enemy_spells, [])
enemy2 = Person("Ultron", 1250, 130, 560, 325, enemy_spells, [])
enemy3 = Person("Thanos", 18200, 701, 525, 25, enemy_spells, [])

players = [player1,player2,player3]
enemies = [enemy1,enemy2,enemy3]
running = True

i=0

print(bcolors.FAIL+bcolors.BOLD+" An Enemy Attacks!" +bcolors.ENDC)

while running:
    print("================================")
    print("Name                       HP                                      MP")
    for player in players:
        player.get_stats()
    print("\n")
    for enemy in enemies:
        enemy.get_enemy_stats()
    for player in players:

        player.choose_action()
        choice = input("    ChooseAction:")
        index = int(choice) -1

        if index == 0:
            dmg = player.generate_damage()
            enemy = player.choose_target(enemies)
            enemies[enemy].take_damage(dmg)
            print("You attacked "+ enemies[enemy].name +" for ",dmg," points of damage.")
            if enemies[enemy].get_hp() == 0:
                print(enemies[enemy].name + " has died.")
                del enemies[enemy]
        elif index == 1:
            player.choose_magic()
            magic_choice = int(input("    Choose Magic"))-1

            if magic_choice == -1:
                continue

            spell=player.magic[magic_choice]
            magic_dmg=spell.generate_damage()

            current_mp = player.get_mp()

            if spell.cost>current_mp:
                print(bcolors.FAIL+" Not enough magic points "+bcolors.ENDC)
                continue
            player.reduce_mp(spell.cost)
            if spell.type == "white":
                player.heal(magic_dmg)
                print(bcolors.OKBLUE+"\n"+spell.name+" heals for ",str(magic_dmg)," HP "+bcolors.ENDC)

            elif spell.type == "black":
                enemy = player.choose_target(enemies)
                enemies[enemy].take_damage(magic_dmg)

                print(bcolors.OKBLUE+"\n"+spell.name+" deals ",str(magic_dmg)," points of damage to "+ enemies[enemy].name +bcolors.ENDC)
                if enemies[enemy].get_hp() == 0:
                    print(enemies[enemy].name + " has died.")
                    del enemies[enemy]
        elif index == 2:
            player.choose_item()
            item_choice = int(input("    Choose Item:"))-1

            if item_choice == -1:
                continue

            item = player.items[item_choice]["item"]
            if player.items[item_choice]["quantity"] == 0:
                print(bcolors.FAIL+"\n"+" None Left "+bcolors.ENDC)
                continue
            player.items[item_choice]["quantity"] -= 1

            if item.type == "potion":
                player.heal(item.prop)
                print(bcolors.OKGREEN+"\n"+item.name+" heals for "+str(item.prop)," HP "+bcolors.ENDC)

            elif item.type == "elixer":
                if item.name == "MegaElixer":
                    for i in players:
                        i.hp = i.maxhp
                        i.mp = i.maxmp
                else:
                    player.hp = player.maxhp
                    player.mp = player.maxmp
                print(bcolors.OKGREEN+"\n"+item.name+" fully restored "+bcolors.ENDC)

            elif item.type == "attack":
                enemy = player.choose_target(enemies)
                enemies[enemy].take_damage(item.prop)

                print(bcolors.FAIL+"\n"+item.name+" deals "+str(item.prop)," points of damage to "+enemies[enemy].name +bcolors.ENDC)
                if enemies[enemy].get_hp() == 0:
                    print(enemies[enemy].name + " has died.")
                    del enemies[enemy]
    def_enemies = 0
    def_player = 0
    for enemy in enemies:
        if enemy.get_hp() == 0:
            def_enemies += 1
    for player in players:
        if player.get_hp() == 0:
            def_player += 1
    if def_enemies == 2:
        print(bcolors.OKGREEN+"You Win"+bcolors.ENDC)
        running = False

    elif def_player == 2:
        print(bcolors.FAIL+"You loose"+bcolors.ENDC)
        running = False
    print("\n")
    for enemy in enemies:
        enemy_choice = random.randrange(0, 2)

        if enemy_choice == 0:
            target = random.randrange(0, 3)
            enemy_damage = enemy.generate_damage()
            players[target].take_damage(enemy_damage)
            print( enemy.name+ " Attacks "+players[target].name+" for ",enemy_damage)
        elif enemy_choice == 1:
            spell, magic_dmg = enemy.choose_enemy_spell()
            enemy.reduce_mp(spell.cost)
            if spell.type == "white":
                enemy.heal(magic_dmg)
                print(bcolors.OKBLUE+spell.name+" heals for "+ enemy.name+
                      str(magic_dmg), "HP"+bcolors.ENDC)

            elif spell.type == "black":
                target = random.randrange(0, 3)
                players[target].take_damage(magic_dmg)

                print(bcolors.OKBLUE+"\n"+enemy.name+"'s"+spell.name+" deals ", str(magic_dmg),
                      " points of damage to " + players[target].name + bcolors.ENDC)
                if players[target].get_hp() == 0:
                    print(players[target].name + " has died.")
                    del players[target]
            #print("Enemy chose",spell,"damage is ",magic_dmg)
