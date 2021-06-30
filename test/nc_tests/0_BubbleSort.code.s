.data
	j : .space 4
	i : .space 4
	tmp : .space 4
	s : .space 4
	a : .space 40
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
	sw $t0, i
_temp_label_9:
	lw $t0, i
	li $t1, 10
	li $t3, 1
	blt $t0, $t1, jmp_1
	li $t3, 0
jmp_1:
	sw $t3, -12($fp)
	lw $t0, -12($fp)
	bne $t0, $0, _temp_label_15
	lw $t0, -12($fp)
	beq $t0, $0, _temp_label_21
_temp_label_12:
	lw $t0, i
	sw $t0, -16($fp)
	lw $t0, i
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, i
	j _temp_label_9
_temp_label_15:
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_GetInt
	sw $v0, -20($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	la $t5, a
	lw $t6, i
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
	j _temp_label_12
_temp_label_21:
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
	sw $t0, i
_temp_label_27:
	lw $t0, i
	li $t1, 10
	li $t3, 1
	blt $t0, $t1, jmp_2
	li $t3, 0
jmp_2:
	sw $t3, -36($fp)
	lw $t0, -36($fp)
	bne $t0, $0, _temp_label_33
	lw $t0, -36($fp)
	beq $t0, $0, _temp_label_39
_temp_label_30:
	lw $t0, i
	sw $t0, -40($fp)
	lw $t0, i
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, i
	j _temp_label_27
_temp_label_33:
	la $t5, a
	lw $t6, i
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
	j _temp_label_30
_temp_label_39:
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
	sw $t0, i
_temp_label_45:
	lw $t0, i
	li $t1, 10
	li $t3, 1
	blt $t0, $t1, jmp_3
	li $t3, 0
jmp_3:
	sw $t3, -64($fp)
	lw $t0, -64($fp)
	bne $t0, $0, _temp_label_51
	lw $t0, -64($fp)
	beq $t0, $0, _temp_label_81
_temp_label_48:
	lw $t0, i
	sw $t0, -68($fp)
	lw $t0, i
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, i
	j _temp_label_45
_temp_label_51:
	li $t0, 0
	sw $t0, j
_temp_label_53:
	li $t0, 10
	lw $t1, i
	sub $t2, $t0, $t1
	sw $t2, -72($fp)
	lw $t0, -72($fp)
	li $t1, 1
	sub $t2, $t0, $t1
	sw $t2, -76($fp)
	lw $t0, j
	lw $t1, -76($fp)
	li $t3, 1
	blt $t0, $t1, jmp_4
	li $t3, 0
jmp_4:
	sw $t3, -80($fp)
	lw $t0, -80($fp)
	bne $t0, $0, _temp_label_61
	lw $t0, -80($fp)
	beq $t0, $0, _temp_label_80
_temp_label_58:
	lw $t0, j
	sw $t0, -84($fp)
	lw $t0, j
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, j
	j _temp_label_53
_temp_label_61:
	lw $t0, j
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
	lw $t6, j
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
	bne $t0, $0, _temp_label_67
	j _temp_label_79
_temp_label_67:
	la $t5, a
	lw $t6, j
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -104($fp)
	lw $t0, -104($fp)
	sw $t0, tmp
	lw $t0, j
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
	lw $t6, j
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
	lw $t0, j
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
	lw $t0, tmp
	sw $t0, -120($fp)
	lw $t0, -120($fp)
	sw $t0, ($t5)
_temp_label_79:
	j _temp_label_58
_temp_label_80:
	j _temp_label_48
_temp_label_81:
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
	sw $t0, i
_temp_label_87:
	lw $t0, i
	li $t1, 10
	li $t3, 1
	blt $t0, $t1, jmp_6
	li $t3, 0
jmp_6:
	sw $t3, -136($fp)
	lw $t0, -136($fp)
	bne $t0, $0, _temp_label_93
	lw $t0, -136($fp)
	beq $t0, $0, _temp_label_99
_temp_label_90:
	lw $t0, i
	sw $t0, -140($fp)
	lw $t0, i
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, i
	j _temp_label_87
_temp_label_93:
	la $t5, a
	lw $t6, i
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
	j _temp_label_90
_temp_label_99:
	li $t0, 0
	sw $t0, -156($fp)
	lw $v0, -156($fp)
	addu $sp, $sp, 156
	lw $fp, ($sp)
	addu $sp, $sp, 4
	jr $ra

