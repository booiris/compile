.data
	n : .space 16
	dist : .space 800
	prev : .space 800
	line : .space 16
	maxint : .space 16
	cc : .space 40000
	_2sc : .asciiz "Shortest path length from source point to last vertex:"
	_1sc : .asciiz "\n"
	_0sc : .asciiz "->"
	_3sc : .asciiz "\nThe path is:\n"
	blank : .asciiz " "
.text
	__init:
lui $sp, 0x8000
addi $sp, $sp, 0x0000
move $fp, $sp
add $gp, $gp, 0x8000
jal main
li $v0, 10
syscall
Mars_PrintInt:
li $v0, 1
syscall
li $v0, 4
move $v1, $a0
la $a0, blank
syscall
move $a0, $v1
jr $ra
Mars_GetInt:
li $v0, 5
syscall
jr $ra
Mars_PrintStr:
li $v0, 4
syscall
jr $ra
	li $t0, 999999
	sw $t0, maxint
Dijkskra:
	subu $sp, $sp, 4
	sw $fp, ($sp)
	move $fp, $sp
	subu $sp, $sp, 124
	subu $sp, $sp, 236
	sw $a0, -128($fp)
	sw $a0, -132($fp)
	li $t0, 1
	sw $t0, -336($fp)
_temp_label_15:
	lw $t0, -336($fp)
	lw $t1, -128($fp)
	li $t3, 1
	ble $t0, $t1, jmp_1
	li $t3, 0
jmp_1:
	sw $t3, -4($fp)
	lw $t0, -4($fp)
	bne $t0, $0, _temp_label_20
	lw $t0, -4($fp)
	beq $t0, $0, _temp_label_40
_temp_label_18:
	lw $t0, -336($fp)
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, -336($fp)
	j _temp_label_15
_temp_label_20:
	lw $t0, -132($fp)
	li $t1, 50
	mult $t0, $t1
	mflo $t0
	sw $t0, -8($fp)
	lw $t0, -8($fp)
	lw $t1, -336($fp)
	add $t2, $t0, $t1
	sw $t2, -8($fp)
	la $t5, cc
	lw $t6, -8($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -8($fp)
	la $t5, dist
	lw $t6, -336($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -12($fp)
	lw $t0, -8($fp)
	sw $t0, -12($fp)
	lw $t0, -12($fp)
	sw $t0, ($t5)
	la $t5, -332($fp)
	lw $t6, -336($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -16($fp)
	li $t0, 0
	sw $t0, -16($fp)
	lw $t0, -16($fp)
	sw $t0, ($t5)
	la $t5, dist
	lw $t6, -336($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -20($fp)
	lw $t0, -20($fp)
	lw $t1, maxint
	li $t3, 1
	beq $t0, $t1, jmp_2
	li $t3, 0
jmp_2:
	sw $t3, -24($fp)
	lw $t0, -24($fp)
	beq $t0, $0, _temp_label_36
	la $t5, prev
	lw $t6, -336($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -28($fp)
	li $t0, 0
	sw $t0, -28($fp)
	lw $t0, -28($fp)
	sw $t0, ($t5)
	j _temp_label_39
_temp_label_36:
	la $t5, prev
	lw $t6, -336($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -32($fp)
	lw $t0, -132($fp)
	sw $t0, -32($fp)
	lw $t0, -32($fp)
	sw $t0, ($t5)
_temp_label_39:
	j _temp_label_18
_temp_label_40:
	la $t5, dist
	lw $t6, -132($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -36($fp)
	li $t0, 0
	sw $t0, -36($fp)
	lw $t0, -36($fp)
	sw $t0, ($t5)
	la $t5, -332($fp)
	lw $t6, -132($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -40($fp)
	li $t0, 1
	sw $t0, -40($fp)
	lw $t0, -40($fp)
	sw $t0, ($t5)
	li $t0, 2
	sw $t0, -340($fp)
_temp_label_48:
	lw $t0, -340($fp)
	lw $t1, -128($fp)
	li $t3, 1
	ble $t0, $t1, jmp_3
	li $t3, 0
jmp_3:
	sw $t3, -44($fp)
	lw $t0, -44($fp)
	bne $t0, $0, _temp_label_53
	lw $t0, -44($fp)
	beq $t0, $0, _temp_label_112
_temp_label_51:
	lw $t0, -340($fp)
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, -340($fp)
	j _temp_label_48
_temp_label_53:
	lw $t0, maxint
	sw $t0, -344($fp)
	lw $t0, -132($fp)
	sw $t0, -348($fp)
	li $t0, 1
	sw $t0, -352($fp)
_temp_label_59:
	lw $t0, -352($fp)
	lw $t1, -128($fp)
	li $t3, 1
	ble $t0, $t1, jmp_4
	li $t3, 0
jmp_4:
	sw $t3, -48($fp)
	lw $t0, -48($fp)
	bne $t0, $0, _temp_label_64
	lw $t0, -48($fp)
	beq $t0, $0, _temp_label_75
_temp_label_62:
	lw $t0, -352($fp)
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, -352($fp)
	j _temp_label_59
_temp_label_64:
	la $t5, dist
	lw $t6, -352($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -52($fp)
	lw $t0, -52($fp)
	lw $t1, -344($fp)
	li $t3, 1
	blt $t0, $t1, jmp_5
	li $t3, 0
jmp_5:
	sw $t3, -56($fp)
	la $t5, -332($fp)
	lw $t6, -352($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -64($fp)
	lw $t0, -60($fp)
	lw $t1, -56($fp)
	and $t0, $t0, $t1
	li $t3, 0
	beq $t0, $0, jmp_6
	li $t3, 1
jmp_6:
	sw $t3, -68($fp)
	lw $t0, -68($fp)
	beq $t0, $0, _temp_label_73
	lw $t0, -352($fp)
	sw $t0, -348($fp)
	la $t5, dist
	lw $t6, -352($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -72($fp)
	lw $t0, -72($fp)
	sw $t0, -344($fp)
_temp_label_73:
	j _temp_label_74
_temp_label_74:
	j _temp_label_62
_temp_label_75:
	la $t5, -332($fp)
	lw $t6, -348($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -76($fp)
	li $t0, 1
	sw $t0, -76($fp)
	lw $t0, -76($fp)
	sw $t0, ($t5)
	li $t0, 1
	sw $t0, -356($fp)
_temp_label_80:
	lw $t0, -356($fp)
	lw $t1, -128($fp)
	li $t3, 1
	ble $t0, $t1, jmp_7
	li $t3, 0
jmp_7:
	sw $t3, -80($fp)
	lw $t0, -80($fp)
	bne $t0, $0, _temp_label_85
	lw $t0, -80($fp)
	beq $t0, $0, _temp_label_111
_temp_label_83:
	lw $t0, -356($fp)
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, -356($fp)
	j _temp_label_80
_temp_label_85:
	lw $t0, -348($fp)
	li $t1, 50
	mult $t0, $t1
	mflo $t0
	sw $t0, -84($fp)
	lw $t0, -84($fp)
	lw $t1, -356($fp)
	add $t2, $t0, $t1
	sw $t2, -84($fp)
	la $t5, cc
	lw $t6, -84($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -84($fp)
	lw $t0, -84($fp)
	lw $t1, maxint
	li $t3, 1
	blt $t0, $t1, jmp_8
	li $t3, 0
jmp_8:
	sw $t3, -88($fp)
	la $t5, -332($fp)
	lw $t6, -356($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -96($fp)
	lw $t0, -92($fp)
	lw $t1, -88($fp)
	and $t0, $t0, $t1
	li $t3, 0
	beq $t0, $0, jmp_9
	li $t3, 1
jmp_9:
	sw $t3, -100($fp)
	lw $t0, -100($fp)
	beq $t0, $0, _temp_label_109
	la $t5, dist
	lw $t6, -348($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -104($fp)
	lw $t0, -348($fp)
	li $t1, 50
	mult $t0, $t1
	mflo $t0
	sw $t0, -108($fp)
	lw $t0, -108($fp)
	lw $t1, -356($fp)
	add $t2, $t0, $t1
	sw $t2, -108($fp)
	la $t5, cc
	lw $t6, -108($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -108($fp)
	lw $t0, -104($fp)
	lw $t1, -108($fp)
	add $t2, $t0, $t1
	sw $t2, -360($fp)
	la $t5, dist
	lw $t6, -356($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -112($fp)
	lw $t0, -360($fp)
	lw $t1, -112($fp)
	li $t3, 1
	blt $t0, $t1, jmp_10
	li $t3, 0
jmp_10:
	sw $t3, -116($fp)
	lw $t0, -116($fp)
	beq $t0, $0, _temp_label_108
	la $t5, dist
	lw $t6, -356($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -120($fp)
	lw $t0, -360($fp)
	sw $t0, -120($fp)
	lw $t0, -120($fp)
	sw $t0, ($t5)
	la $t5, prev
	lw $t6, -356($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -124($fp)
	lw $t0, -348($fp)
	sw $t0, -124($fp)
	lw $t0, -124($fp)
	sw $t0, ($t5)
_temp_label_108:
	j _temp_label_109
_temp_label_109:
	j _temp_label_110
_temp_label_110:
	j _temp_label_83
_temp_label_111:
	j _temp_label_51
_temp_label_112:
	j func_1_end
func_1_end:
	addu $sp, $sp, 236
	addu $sp, $sp, 124
	lw $fp, ($sp)
	addu $sp, $sp, 4
	jr $ra
searchPath:
	subu $sp, $sp, 4
	sw $fp, ($sp)
	move $fp, $sp
	subu $sp, $sp, 60
	subu $sp, $sp, 220
	sw $a0, -64($fp)
	sw $a0, -68($fp)
	li $t0, 1
	sw $t0, -272($fp)
	la $t5, -268($fp)
	lw $t6, -272($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -4($fp)
	lw $t0, -68($fp)
	sw $t0, -4($fp)
	lw $t0, -4($fp)
	sw $t0, ($t5)
	lw $t0, -272($fp)
	sw $t0, -8($fp)
	lw $t0, -272($fp)
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, -272($fp)
	la $t5, prev
	lw $t6, -68($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -12($fp)
	lw $t0, -12($fp)
	sw $t0, -276($fp)
_temp_label_131:
_temp_label_134:
	j _temp_label_131
_temp_label_135:
	la $t5, -268($fp)
	lw $t6, -272($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -16($fp)
	lw $t0, -276($fp)
	sw $t0, -16($fp)
	lw $t0, -16($fp)
	sw $t0, ($t5)
	lw $t0, -272($fp)
	sw $t0, -20($fp)
	lw $t0, -272($fp)
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, -272($fp)
	la $t5, prev
	lw $t6, -276($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -24($fp)
	lw $t0, -24($fp)
	sw $t0, -276($fp)
	j _temp_label_134
_temp_label_143:
	la $t5, -268($fp)
	lw $t6, -272($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -28($fp)
	lw $t0, -64($fp)
	sw $t0, -28($fp)
	lw $t0, -28($fp)
	sw $t0, ($t5)
	lw $t0, -272($fp)
	sw $t0, -280($fp)
_temp_label_148:
	lw $t0, -280($fp)
	li $t1, 1
	li $t3, 1
	bge $t0, $t1, jmp_11
	li $t3, 0
jmp_11:
	sw $t3, -32($fp)
	lw $t0, -32($fp)
	bne $t0, $0, _temp_label_153
	lw $t0, -32($fp)
	beq $t0, $0, _temp_label_170
_temp_label_151:
	lw $t0, -280($fp)
	li $t1, 1
	sub $t0, $t0, $t1
	sw $t0, -280($fp)
	j _temp_label_148
_temp_label_153:
	la $t5, -268($fp)
	lw $t6, -280($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -36($fp)
	lw $t0, -36($fp)
	sw $t0, -40($fp)
	lw $a0, -40($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_PrintInt
	sw $v0, -44($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	la $t0, _0sc
	sw $t0, -48($fp)
	lw $a0, -48($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_PrintStr
	sw $v0, -52($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	j _temp_label_169
_temp_label_165:
	la $t0, _1sc
	sw $t0, -56($fp)
	lw $a0, -56($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_PrintStr
	sw $v0, -60($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
_temp_label_169:
	j _temp_label_151
_temp_label_170:
	j func_2_end
func_2_end:
	addu $sp, $sp, 220
	addu $sp, $sp, 60
	lw $fp, ($sp)
	addu $sp, $sp, 4
	jr $ra
main:
	subu $sp, $sp, 4
	sw $fp, ($sp)
	move $fp, $sp
	subu $sp, $sp, 148
	subu $sp, $sp, 36
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_GetInt
	sw $v0, -4($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	lw $t0, -4($fp)
	sw $t0, n
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_GetInt
	sw $v0, -8($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	lw $t0, -8($fp)
	sw $t0, line
	li $t0, 1
	sw $t0, -164($fp)
_temp_label_185:
	lw $t0, -164($fp)
	lw $t1, n
	li $t3, 1
	ble $t0, $t1, jmp_12
	li $t3, 0
jmp_12:
	sw $t3, -12($fp)
	lw $t0, -12($fp)
	bne $t0, $0, _temp_label_190
	lw $t0, -12($fp)
	beq $t0, $0, _temp_label_205
_temp_label_188:
	lw $t0, -164($fp)
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, -164($fp)
	j _temp_label_185
_temp_label_190:
	li $t0, 1
	sw $t0, -168($fp)
_temp_label_192:
	lw $t0, -168($fp)
	lw $t1, n
	li $t3, 1
	ble $t0, $t1, jmp_13
	li $t3, 0
jmp_13:
	sw $t3, -16($fp)
	lw $t0, -16($fp)
	bne $t0, $0, _temp_label_198
	lw $t0, -16($fp)
	beq $t0, $0, _temp_label_204
_temp_label_195:
	lw $t0, -168($fp)
	sw $t0, -20($fp)
	lw $t0, -168($fp)
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, -168($fp)
	j _temp_label_192
_temp_label_198:
	lw $t0, -164($fp)
	li $t1, 50
	mult $t0, $t1
	mflo $t0
	sw $t0, -24($fp)
	lw $t0, -24($fp)
	lw $t1, -168($fp)
	add $t2, $t0, $t1
	sw $t2, -24($fp)
	la $t5, cc
	lw $t6, -24($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -24($fp)
	lw $t0, maxint
	sw $t0, -24($fp)
	lw $t0, -24($fp)
	sw $t0, ($t5)
	j _temp_label_195
_temp_label_204:
	j _temp_label_188
_temp_label_205:
	li $t0, 1
	sw $t0, -172($fp)
_temp_label_207:
	lw $t0, -172($fp)
	lw $t1, line
	li $t3, 1
	ble $t0, $t1, jmp_14
	li $t3, 0
jmp_14:
	sw $t3, -28($fp)
	lw $t0, -28($fp)
	bne $t0, $0, _temp_label_212
	lw $t0, -28($fp)
	beq $t0, $0, _temp_label_238
_temp_label_210:
	lw $t0, -172($fp)
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, -172($fp)
	j _temp_label_207
_temp_label_212:
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_GetInt
	sw $v0, -32($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	lw $t0, -32($fp)
	sw $t0, -152($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_GetInt
	sw $v0, -36($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	lw $t0, -36($fp)
	sw $t0, -156($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_GetInt
	sw $v0, -40($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	lw $t0, -40($fp)
	sw $t0, -160($fp)
	lw $t0, -152($fp)
	li $t1, 50
	mult $t0, $t1
	mflo $t0
	sw $t0, -44($fp)
	lw $t0, -44($fp)
	lw $t1, -156($fp)
	add $t2, $t0, $t1
	sw $t2, -44($fp)
	la $t5, cc
	lw $t6, -44($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -44($fp)
	lw $t0, -160($fp)
	lw $t1, -44($fp)
	li $t3, 1
	blt $t0, $t1, jmp_15
	li $t3, 0
jmp_15:
	sw $t3, -48($fp)
	lw $t0, -48($fp)
	beq $t0, $0, _temp_label_236
	lw $t0, -152($fp)
	li $t1, 50
	mult $t0, $t1
	mflo $t0
	sw $t0, -52($fp)
	lw $t0, -52($fp)
	lw $t1, -156($fp)
	add $t2, $t0, $t1
	sw $t2, -52($fp)
	la $t5, cc
	lw $t6, -52($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -52($fp)
	lw $t0, -160($fp)
	sw $t0, -52($fp)
	lw $t0, -52($fp)
	sw $t0, ($t5)
	lw $t0, -156($fp)
	li $t1, 50
	mult $t0, $t1
	mflo $t0
	sw $t0, -56($fp)
	lw $t0, -56($fp)
	lw $t1, -152($fp)
	add $t2, $t0, $t1
	sw $t2, -56($fp)
	la $t5, cc
	lw $t6, -56($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -56($fp)
	lw $t0, -160($fp)
	sw $t0, -56($fp)
	lw $t0, -56($fp)
	sw $t0, ($t5)
_temp_label_236:
	j _temp_label_237
_temp_label_237:
	j _temp_label_210
_temp_label_238:
	li $t0, 1
	sw $t0, -176($fp)
_temp_label_240:
	lw $t0, -176($fp)
	lw $t1, n
	li $t3, 1
	ble $t0, $t1, jmp_16
	li $t3, 0
jmp_16:
	sw $t3, -60($fp)
	lw $t0, -60($fp)
	bne $t0, $0, _temp_label_245
	lw $t0, -60($fp)
	beq $t0, $0, _temp_label_249
_temp_label_243:
	lw $t0, -176($fp)
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, -176($fp)
	j _temp_label_240
_temp_label_245:
	la $t5, dist
	lw $t6, -176($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -64($fp)
	lw $t0, maxint
	sw $t0, -64($fp)
	lw $t0, -64($fp)
	sw $t0, ($t5)
	j _temp_label_243
_temp_label_249:
	li $t0, 1
	sw $t0, -180($fp)
_temp_label_251:
	lw $t0, -180($fp)
	lw $t1, n
	li $t3, 1
	ble $t0, $t1, jmp_17
	li $t3, 0
jmp_17:
	sw $t3, -68($fp)
	lw $t0, -68($fp)
	bne $t0, $0, _temp_label_256
	lw $t0, -68($fp)
	beq $t0, $0, _temp_label_276
_temp_label_254:
	lw $t0, -180($fp)
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, -180($fp)
	j _temp_label_251
_temp_label_256:
	li $t0, 1
	sw $t0, -184($fp)
_temp_label_258:
	lw $t0, -184($fp)
	lw $t1, n
	li $t3, 1
	ble $t0, $t1, jmp_18
	li $t3, 0
jmp_18:
	sw $t3, -72($fp)
	lw $t0, -72($fp)
	bne $t0, $0, _temp_label_263
	lw $t0, -72($fp)
	beq $t0, $0, _temp_label_271
_temp_label_261:
	lw $t0, -184($fp)
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, -184($fp)
	j _temp_label_258
_temp_label_263:
	lw $t0, -180($fp)
	li $t1, 50
	mult $t0, $t1
	mflo $t0
	sw $t0, -76($fp)
	lw $t0, -76($fp)
	lw $t1, -184($fp)
	add $t2, $t0, $t1
	sw $t2, -76($fp)
	la $t5, cc
	lw $t6, -76($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -76($fp)
	lw $t0, -76($fp)
	sw $t0, -80($fp)
	lw $a0, -80($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_PrintInt
	sw $v0, -84($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	j _temp_label_261
_temp_label_271:
	la $t0, _1sc
	sw $t0, -88($fp)
	lw $a0, -88($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_PrintStr
	sw $v0, -92($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	j _temp_label_254
_temp_label_276:
	lw $t0, n
	sw $t0, -96($fp)
	lw $a0, -96($fp)
	li $t0, 1
	sw $t0, -100($fp)
	lw $a1, -100($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Dijkskra
	sw $v0, -104($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	la $t0, _2sc
	sw $t0, -108($fp)
	lw $a0, -108($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_PrintStr
	sw $v0, -112($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	la $t5, dist
	lw $t6, n
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -116($fp)
	lw $t0, -116($fp)
	sw $t0, -120($fp)
	lw $a0, -120($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_PrintInt
	sw $v0, -124($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	la $t0, _3sc
	sw $t0, -128($fp)
	lw $a0, -128($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_PrintStr
	sw $v0, -132($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	li $t0, 1
	sw $t0, -136($fp)
	lw $a0, -136($fp)
	lw $t0, n
	sw $t0, -140($fp)
	lw $a1, -140($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal searchPath
	sw $v0, -144($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	li $t0, 0
	sw $t0, -148($fp)
	lw $v0, -148($fp)
	j func_3_end
func_3_end:
	addu $sp, $sp, 36
	addu $sp, $sp, 148
	lw $fp, ($sp)
	addu $sp, $sp, 4
	jr $ra

