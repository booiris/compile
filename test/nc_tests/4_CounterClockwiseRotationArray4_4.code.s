.data
	_1sc : .asciiz "Array A:\n"
	_3sc : .asciiz "Array B:\n"
	_2sc : .asciiz "\n"
	_0sc : .asciiz "Please Input 16 numbers:\n"
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
array4_4:
	subu $sp, $sp, 4
	sw $fp, ($sp)
	move $fp, $sp
	subu $sp, $sp, 132
	subu $sp, $sp, 136
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
	sw $t0, -264($fp)
_temp_label_10:
	lw $t0, -264($fp)
	li $t1, 4
	li $t3, 1
	blt $t0, $t1, jmp_1
	li $t3, 0
jmp_1:
	sw $t3, -12($fp)
	lw $t0, -12($fp)
	bne $t0, $0, _temp_label_16
	lw $t0, -12($fp)
	beq $t0, $0, _temp_label_41
_temp_label_13:
	lw $t0, -264($fp)
	sw $t0, -16($fp)
	lw $t0, -264($fp)
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, -264($fp)
	j _temp_label_10
_temp_label_16:
	li $t0, 0
	sw $t0, -268($fp)
_temp_label_17:
	lw $t0, -268($fp)
	li $t1, 4
	li $t3, 1
	blt $t0, $t1, jmp_2
	li $t3, 0
jmp_2:
	sw $t3, -20($fp)
	lw $t0, -20($fp)
	bne $t0, $0, _temp_label_23
	lw $t0, -20($fp)
	beq $t0, $0, _temp_label_40
_temp_label_20:
	lw $t0, -268($fp)
	sw $t0, -24($fp)
	lw $t0, -268($fp)
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, -268($fp)
	j _temp_label_17
_temp_label_23:
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_GetInt
	sw $v0, -28($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	lw $t0, -264($fp)
	li $t1, 4
	mult $t0, $t1
	mflo $t0
	sw $t0, -32($fp)
	lw $t0, -32($fp)
	lw $t1, -268($fp)
	add $t2, $t0, $t1
	sw $t2, -32($fp)
	la $t5, -196($fp)
	lw $t6, -32($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -32($fp)
	lw $t0, -28($fp)
	sw $t0, -32($fp)
	lw $t0, -32($fp)
	sw $t0, ($t5)
	lw $t0, -264($fp)
	li $t1, 4
	mult $t0, $t1
	mflo $t0
	sw $t0, -36($fp)
	lw $t0, -36($fp)
	lw $t1, -268($fp)
	add $t2, $t0, $t1
	sw $t2, -36($fp)
	la $t5, -196($fp)
	lw $t6, -36($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -36($fp)
	li $t0, 3
	lw $t1, -268($fp)
	sub $t2, $t0, $t1
	sw $t2, -40($fp)
	lw $t0, -40($fp)
	li $t1, 4
	mult $t0, $t1
	mflo $t0
	sw $t0, -44($fp)
	lw $t0, -44($fp)
	lw $t1, -264($fp)
	add $t2, $t0, $t1
	sw $t2, -44($fp)
	la $t5, -260($fp)
	lw $t6, -44($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -44($fp)
	lw $t0, -36($fp)
	sw $t0, -44($fp)
	lw $t0, -44($fp)
	sw $t0, ($t5)
	j _temp_label_20
_temp_label_40:
	j _temp_label_13
_temp_label_41:
	la $t0, _1sc
	sw $t0, -48($fp)
	lw $a0, -48($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_PrintStr
	sw $v0, -52($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	li $t0, 0
	sw $t0, -264($fp)
_temp_label_46:
	lw $t0, -264($fp)
	li $t1, 4
	li $t3, 1
	blt $t0, $t1, jmp_3
	li $t3, 0
jmp_3:
	sw $t3, -56($fp)
	lw $t0, -56($fp)
	bne $t0, $0, _temp_label_52
	lw $t0, -56($fp)
	beq $t0, $0, _temp_label_72
_temp_label_49:
	lw $t0, -264($fp)
	sw $t0, -60($fp)
	lw $t0, -264($fp)
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, -264($fp)
	j _temp_label_46
_temp_label_52:
	li $t0, 0
	sw $t0, -268($fp)
_temp_label_53:
	lw $t0, -268($fp)
	li $t1, 4
	li $t3, 1
	blt $t0, $t1, jmp_4
	li $t3, 0
jmp_4:
	sw $t3, -64($fp)
	lw $t0, -64($fp)
	bne $t0, $0, _temp_label_59
	lw $t0, -64($fp)
	beq $t0, $0, _temp_label_67
_temp_label_56:
	lw $t0, -268($fp)
	sw $t0, -68($fp)
	lw $t0, -268($fp)
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, -268($fp)
	j _temp_label_53
_temp_label_59:
	lw $t0, -264($fp)
	li $t1, 4
	mult $t0, $t1
	mflo $t0
	sw $t0, -72($fp)
	lw $t0, -72($fp)
	lw $t1, -268($fp)
	add $t2, $t0, $t1
	sw $t2, -72($fp)
	la $t5, -196($fp)
	lw $t6, -72($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -72($fp)
	lw $t0, -72($fp)
	sw $t0, -76($fp)
	lw $a0, -76($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_PrintInt
	sw $v0, -80($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	j _temp_label_56
_temp_label_67:
	la $t0, _2sc
	sw $t0, -84($fp)
	lw $a0, -84($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_PrintStr
	sw $v0, -88($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	j _temp_label_49
_temp_label_72:
	la $t0, _3sc
	sw $t0, -92($fp)
	lw $a0, -92($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_PrintStr
	sw $v0, -96($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	li $t0, 0
	sw $t0, -264($fp)
_temp_label_77:
	lw $t0, -264($fp)
	li $t1, 4
	li $t3, 1
	blt $t0, $t1, jmp_5
	li $t3, 0
jmp_5:
	sw $t3, -100($fp)
	lw $t0, -100($fp)
	bne $t0, $0, _temp_label_83
	lw $t0, -100($fp)
	beq $t0, $0, _temp_label_103
_temp_label_80:
	lw $t0, -264($fp)
	sw $t0, -104($fp)
	lw $t0, -264($fp)
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, -264($fp)
	j _temp_label_77
_temp_label_83:
	li $t0, 0
	sw $t0, -268($fp)
_temp_label_84:
	lw $t0, -268($fp)
	li $t1, 4
	li $t3, 1
	blt $t0, $t1, jmp_6
	li $t3, 0
jmp_6:
	sw $t3, -108($fp)
	lw $t0, -108($fp)
	bne $t0, $0, _temp_label_90
	lw $t0, -108($fp)
	beq $t0, $0, _temp_label_98
_temp_label_87:
	lw $t0, -268($fp)
	sw $t0, -112($fp)
	lw $t0, -268($fp)
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, -268($fp)
	j _temp_label_84
_temp_label_90:
	lw $t0, -264($fp)
	li $t1, 4
	mult $t0, $t1
	mflo $t0
	sw $t0, -116($fp)
	lw $t0, -116($fp)
	lw $t1, -268($fp)
	add $t2, $t0, $t1
	sw $t2, -116($fp)
	la $t5, -260($fp)
	lw $t6, -116($fp)
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
	j _temp_label_87
_temp_label_98:
	la $t0, _2sc
	sw $t0, -128($fp)
	lw $a0, -128($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_PrintStr
	sw $v0, -132($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	j _temp_label_80
_temp_label_103:
	j func_1_end
func_1_end:
	addu $sp, $sp, 136
	addu $sp, $sp, 132
	lw $fp, ($sp)
	addu $sp, $sp, 4
	jr $ra
main:
	subu $sp, $sp, 4
	sw $fp, ($sp)
	move $fp, $sp
	subu $sp, $sp, 8
	subu $sp, $sp, 0
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal array4_4
	sw $v0, -4($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	li $t0, 0
	sw $t0, -8($fp)
	lw $v0, -8($fp)
	j func_2_end
func_2_end:
	addu $sp, $sp, 0
	addu $sp, $sp, 8
	lw $fp, ($sp)
	addu $sp, $sp, 4
	jr $ra

