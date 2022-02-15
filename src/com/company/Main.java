package com.company;

import com.company.characters.*;
import com.company.exceptions.InvalidArmorException;
import com.company.exceptions.InvalidWeaponException;
import com.company.items.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InvalidArmorException, InvalidWeaponException {
        Scanner gameScanner = new Scanner(System.in);
        Map<String, CharacterClass> characters = new HashMap<>();
        while(true){
            System.out.println("Type in the desired command.");
            System.out.println("Available commands are:\ncreateCharacter\nlevelUp\nequipItem\nprintCharacter\ngetDPS\nexit");
            String command = gameScanner.nextLine();
            if(command.equalsIgnoreCase("exit")){
                break;
            }
            switch(command){
                case "createCharacter":
                    System.out.println("Type in class and name with space between like this: 'mage Khadgar'");
                    String classChoice = gameScanner.nextLine();
                    String[] choices = classChoice.split(" ");
                    CharacterClass newCharacter = null;
                    if(choices[0].equalsIgnoreCase("mage")){
                        newCharacter = new MageClass(choices[1]);
                    }else if(choices[0].equalsIgnoreCase("ranger")){
                        newCharacter = new RangerClass(choices[1]);
                    }else if(choices[0].equalsIgnoreCase("rogue")){
                        newCharacter = new RogueClass(choices[1]);
                    }else if(choices[0].equalsIgnoreCase("warrior")){
                        newCharacter = new WarriorClass(choices[1]);
                    }
                    characters.put(choices[1].toLowerCase(), newCharacter);
                    break;
                case "levelUp":
                    System.out.println("Which character should level up?");
                    String name = gameScanner.nextLine();
                    characters.get(name.toLowerCase()).incrementLevel();
                    break;
                case "equipItem":
                    System.out.println("Weapon or Armor?");
                    String choice = gameScanner.nextLine();
                    if(choice.equalsIgnoreCase("weapon")){
                        System.out.println("Enter name, required level, weapon type, damage and attack speed in order with space between each parameter.");
                        String weaponParameters = gameScanner.nextLine();
                        String[] parameters = weaponParameters.split(" ");
                        WeaponType type = null;
                        if(parameters[2].equalsIgnoreCase("sword")){
                            type = WeaponType.SWORD;
                        }else if(parameters[2].equalsIgnoreCase("dagger")){
                            type = WeaponType.DAGGER;
                        }else if(parameters[2].equalsIgnoreCase("bow")){
                            type = WeaponType.BOW;
                        }else if(parameters[2].equalsIgnoreCase("hammer")){
                            type = WeaponType.HAMMER;
                        }else if(parameters[2].equalsIgnoreCase("staff")){
                            type = WeaponType.STAFF;
                        }else if(parameters[2].equalsIgnoreCase("wand")){
                            type = WeaponType.WAND;
                        }else if(parameters[2].equalsIgnoreCase("axe")){
                            type = WeaponType.AXE;
                        }
                        Item weapon = new Weapon(parameters[0], Integer.parseInt(parameters[1]), type, Double.parseDouble(parameters[3]), Double.parseDouble(parameters[4]));
                        System.out.println("For which character is this weapon?");
                        String character = gameScanner.nextLine();
                        CharacterClass characterObject = characters.get(character.toLowerCase());
                        characterObject.equipItem(weapon);
                    }else if(choice.equalsIgnoreCase("armor")){
                        System.out.println("Enter name, required level, equipment slot, armor type, strength, dexterity and intelligence in order with space between each parameter.");
                        String weaponParameters = gameScanner.nextLine();
                        String[] parameters = weaponParameters.split(" ");
                        ArmorType type = null;
                        EquipmentSlot slot = null;
                        if(parameters[2].equalsIgnoreCase("head")){
                            slot = EquipmentSlot.HEAD;
                        }else if(parameters[2].equalsIgnoreCase("body")){
                            slot = EquipmentSlot.BODY;
                        }else if(parameters[2].equalsIgnoreCase("legs")){
                            slot = EquipmentSlot.LEGS;
                        }
                        if(parameters[3].equalsIgnoreCase("cloth")){
                            type = ArmorType.CLOTH;
                        }else if(parameters[3].equalsIgnoreCase("leather")){
                            type = ArmorType.LEATHER;
                        }else if(parameters[3].equalsIgnoreCase("mail")){
                            type = ArmorType.MAIL;
                        }else if(parameters[3].equalsIgnoreCase("plate")){
                            type = ArmorType.PLATE;
                        }
                        Item armor = new Armor(parameters[0], Integer.parseInt(parameters[1]), slot, type, Integer.parseInt(parameters[4]), Integer.parseInt(parameters[5]), Integer.parseInt(parameters[6]));
                        System.out.println("For which character is this armor?");
                        String character = gameScanner.nextLine();
                        CharacterClass characterObject = characters.get(character.toLowerCase());
                        characterObject.equipItem(armor);
                    }
                    break;
                case "printCharacter":
                    System.out.println("Name of character you wish to print in console?");
                    String characterName = gameScanner.nextLine();
                    System.out.println(characters.get(characterName.toLowerCase()));
                    break;
                case "getDPS":
                    System.out.println("Name of character you wish to see DPS of?");
                    String charactersName = gameScanner.nextLine();
                    System.out.println(((DamageDealer) characters.get(charactersName.toLowerCase())).getDPS());
                    break;
            }
        }
        gameScanner.close();
        System.out.println("Goodbye!");
    }
}
