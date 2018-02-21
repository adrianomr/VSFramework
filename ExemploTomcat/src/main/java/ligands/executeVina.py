#!/usr/bin/python
# -*- coding: utf-8 -*-
import subprocess
from subprocess import Popen
import os
import shlex
import time
import os
from os import listdir
from os.path import isfile, join
from random import randint

receptor ="00_align_1S48_Phyre.PDBQT"
ligand ="V20.PDBQT"
aux_ligand ="V20"
aux_receptor ="00_align_1S48_Phyre"
receptor_path = "/home/adriano/Dropbox/Adriano/ExemploTomcat/src/main/java/receptors"
ligand_path = "/home/adriano/Dropbox/Adriano/ExemploTomcat/src/main/java/ligands"
output_path = "/home/adriano/Dropbox/Adriano/ExemploTomcat/src/main/java/outputpath/"
size_x = 50.0
size_y = 50.0
size_z = 50.0
center_x = 0.0
center_y = 0.0
center_z = 0.0
receptor = "receptor = "+receptor+""
ligand = "ligand = "+ligand+""

#Creation of file conf.txt (it is necessary to AutoDock Vina run)
lista = [receptor+"\n" , ligand +"\n", "seed = 1234567891\n" , "out = out.pdb\n\n" , "center_x =  0.0 \n" , "center_y = 0.0\n" , "center_z = 0.0\n\n","size_x = 50.0\n" , "size_y = 50.0 \n" , "size_z = 50.0\n\n" , "exhaustiveness = 8"]

f = open("/home/adriano/Dropbox/Adriano/ExemploTomcat/src/main/java/receptors/conf.txt" ,"w")
for elem in lista:
	f.write("%s" % elem)

f.close()
#-----------------------------------------
#Creation of file .sh to play the autodock vina

f = open("/home/adriano/Dropbox/Adriano/ExemploTomcat/src/main/java/receptors/executa_vina.sh","w")
f.write("vina --config /home/adriano/Dropbox/Adriano/ExemploTomcat/src/main/java/receptors/conf.txt --ligand %s%s.pdbqt --receptor %s%s.pdbqt --out /home/adriano/Dropbox/Adriano/ExemploTomcat/src/main/java/outputpath/out_%s.pdbqt --log /home/adriano/Dropbox/Adriano/ExemploTomcat/src/main/java/outputpath/log_%s.txt" % (ligand_path, aux_ligand, receptor_path, aux_receptor, aux_ligand, aux_ligand))
f.close()
#-----------------------------------------
os.system("chmod 777 /home/adriano/Dropbox/Adriano/ExemploTomcat/src/main/java/receptors/executa_vina.sh")
print ("Vina is Running")
os.system("/home/adriano/Dropbox/Adriano/ExemploTomcat/src/main/java/receptors/executa_vina.sh")#Call to execution of AutoDock Vina
