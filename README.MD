#Calculate Damage App

####by Alexander Sachs

###A CLI app that calculates damage of three different attacks with inputs given by the user

The damage is calculated using the following equations:

**same element bonus:**

((1 + weaponsBonus/100) * minOrMaxDMG * PercentOfWeaponDamage/100 * (1 + elementBonus/100))

**separate element bonus:**

((1 + weaponsBonus/100) * PercentOfWeaponDamage/100 * minOrMaxDMG)


for example:

WeaponBonus = 20
minDMG = 50
percentOfWeaponDamage = 90
elementBonus = 10

result: 59.4 for Axe attacking with Firemostsmite

**Note**

These calculations were run based off of the example table, which doesn't appear to account 
for Lena's experience level. 