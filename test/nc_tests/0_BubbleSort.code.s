.data
	j : .space 216
	i : .space 224
	tmp : .space 220
	s : .space 160
	a : .space 200
	_1sc : .asciiz "before bubble sort:\n"
	_3sc : .asciiz "after bubble sort:\n"
	_0sc : .asciiz "please input ten int number for bubble sort:\n"
	_2sc : .asciiz "\n"
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
main:
	subu $sp, $sp, 4
	sw $fp, ($sp)
	move $fp, $sp
	subu $sp, $sp, 156
	subu $sp, $sp, 68
	sw $a0, -160($fp)
	la $t0, _0sc
	sw $t0, -4($fp)
	lw $a0, -4($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_PrintStr
	sw $v0, -8($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	li $t0, 0
	sw $t0, -204($fp)
_temp_label_10:
	lw $t0, -204($fp)
	li $t1, 10
	li $t3, 1
	blt $t0, $t1, jmp_1
	li $t3, 0
jmp_1:
	sw $t3, -12($fp)
	lw $t0, -12($fp)
	bne $t0, $0, _temp_label_16
	lw $t0, -12($fp)
	beq $t0, $0, _temp_label_22
_temp_label_13:
	lw $t0, -204($fp)
	sw $t0, -16($fp)
	lw $t0, -204($fp)
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, -204($fp)
	j _temp_label_10
_temp_label_16:
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_GetInt
	sw $v0, -20($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	la $t5, a
	lw $t6, -204($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -24($fp)
	lw $t0, -20($fp)
	sw $t0, -24($fp)
	lw $t0, -24($fp)
	sw $t0, ($t5)
	j _temp_label_13
_temp_label_22:
	la $t0, _1sc
	sw $t0, -28($fp)
	lw $a0, -28($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_PrintStr
	sw $v0, -32($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	li $t0, 0
	sw $t0, -208($fp)
_temp_label_28:
	lw $t0, -208($fp)
	li $t1, 10
	li $t3, 1
	blt $t0, $t1, jmp_2
	li $t3, 0
jmp_2:
	sw $t3, -36($fp)
	lw $t0, -36($fp)
	bne $t0, $0, _temp_label_34
	lw $t0, -36($fp)
	beq $t0, $0, _temp_label_40
_temp_label_31:
	lw $t0, -208($fp)
	sw $t0, -40($fp)
	lw $t0, -208($fp)
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, -208($fp)
	j _temp_label_28
_temp_label_34:
	la $t5, a
	lw $t6, -208($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -44($fp)
	lw $t0, -44($fp)
	sw $t0, -48($fp)
	lw $a0, -48($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_PrintInt
	sw $v0, -52($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	j _temp_label_31
_temp_label_40:
	la $t0, _2sc
	sw $t0, -56($fp)
	lw $a0, -56($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_PrintStr
	sw $v0, -60($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	li $t0, 0
	sw $t0, -212($fp)
_temp_label_46:
	lw $t0, -212($fp)
	li $t1, 10
	li $t3, 1
	blt $t0, $t1, jmp_3
	li $t3, 0
jmp_3:
	sw $t3, -64($fp)
	lw $t0, -64($fp)
	bne $t0, $0, _temp_label_52
	lw $t0, -64($fp)
	beq $t0, $0, _temp_label_82
_temp_label_49:
	lw $t0, -212($fp)
	sw $t0, -68($fp)
	lw $t0, -212($fp)
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, -212($fp)
	j _temp_label_46
_temp_label_52:
	li $t0, 0
	sw $t0, -216($fp)
_temp_label_54:
	li $t0, 10
	lw $t1, -212($fp)
	sub $t2, $t0, $t1
	sw $t2, -72($fp)
	lw $t0, -72($fp)
	li $t1, 1
	sub $t2, $t0, $t1
	sw $t2, -76($fp)
	lw $t0, -216($fp)
	lw $t1, -76($fp)
	li $t3, 1
	blt $t0, $t1, jmp_4
	li $t3, 0
jmp_4:
	sw $t3, -80($fp)
	lw $t0, -80($fp)
	bne $t0, $0, _temp_label_62
	lw $t0, -80($fp)
	beq $t0, $0, _temp_label_81
_temp_label_59:
	lw $t0, -216($fp)
	sw $t0, -84($fp)
	lw $t0, -216($fp)
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, -216($fp)
	j _temp_label_54
_temp_label_62:
	lw $t0, -216($fp)
	li $t1, 1
	add $t2, $t0, $t1
	sw $t2, -92($fp)
	la $t5, a
	lw $t6, -92($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -88($fp)
	la $t5, a
	lw $t6, -216($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -96($fp)
	lw $t0, -96($fp)
	lw $t1, -88($fp)
	li $t3, 1
	bgt $t0, $t1, jmp_5
	li $t3, 0
jmp_5:
	sw $t3, -100($fp)
	lw $t0, -100($fp)
	beq $t0, $0, _temp_label_79
	la $t5, a
	lw $t6, -216($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -104($fp)
	lw $t0, -104($fp)
	sw $t0, -220($fp)
	lw $t0, -216($fp)
	li $t1, 1
	add $t2, $t0, $t1
	sw $t2, -112($fp)
	la $t5, a
	lw $t6, -112($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -108($fp)
	la $t5, a
	lw $t6, -216($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -116($fp)
	lw $t0, -108($fp)
	sw $t0, -116($fp)
	lw $t0, -116($fp)
	sw $t0, ($t5)
	lw $t0, -216($fp)
	li $t1, 1
	add $t2, $t0, $t1
	sw $t2, -124($fp)
	la $t5, a
	lw $t6, -124($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -120($fp)
	lw $t0, -220($fp)
	sw $t0, -120($fp)
	lw $t0, -120($fp)
	sw $t0, ($t5)
_temp_label_79:
	j _temp_label_80
_temp_label_80:
	j _temp_label_59
_temp_label_81:
	j _temp_label_49
_temp_label_82:
	la $t0, _3sc
	sw $t0, -128($fp)
	lw $a0, -128($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_PrintStr
	sw $v0, -132($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	li $t0, 0
	sw $t0, -224($fp)
_temp_label_88:
	lw $t0, -224($fp)
	li $t1, 10
	li $t3, 1
	blt $t0, $t1, jmp_6
	li $t3, 0
jmp_6:
	sw $t3, -136($fp)
	lw $t0, -136($fp)
	bne $t0, $0, _temp_label_94
	lw $t0, -136($fp)
	beq $t0, $0, _temp_label_100
_temp_label_91:
	lw $t0, -224($fp)
	sw $t0, -140($fp)
	lw $t0, -224($fp)
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, -224($fp)
	j _temp_label_88
_temp_label_94:
	la $t5, a
	lw $t6, -224($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -144($fp)
	lw $t0, -144($fp)
	sw $t0, -148($fp)
	lw $a0, -148($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_PrintInt
	sw $v0, -152($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	j _temp_label_91
_temp_label_100:
	li $t0, 0
	sw $t0, -156($fp)
	lw $v0, -156($fp)
	j func_1_end
func_1_end:
	addu $sp, $sp, 68
	addu $sp, $sp, 156
	lw $fp, ($sp)
	addu $sp, $sp, 4
	jr $ra

