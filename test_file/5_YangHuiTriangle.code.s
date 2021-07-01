.data
	_0sc : .asciiz "\n"
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
YangHuiTriangle:
	subu $sp, $sp, 4
	sw $fp, ($sp)
	move $fp, $sp
	subu $sp, $sp, 96
	subu $sp, $sp, 264
	li $t0, 0
	sw $t0, -100($fp)
_temp_label_5:
	lw $t0, -100($fp)
	li $t1, 8
	li $t3, 1
	blt $t0, $t1, jmp_1
	li $t3, 0
jmp_1:
	sw $t3, -4($fp)
	lw $t0, -4($fp)
	bne $t0, $0, _temp_label_11
	lw $t0, -4($fp)
	beq $t0, $0, _temp_label_25
_temp_label_8:
	lw $t0, -100($fp)
	sw $t0, -8($fp)
	lw $t0, -100($fp)
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, -100($fp)
	j _temp_label_5
_temp_label_11:
	li $t0, 0
	sw $t0, -104($fp)
_temp_label_12:
	lw $t0, -104($fp)
	li $t1, 8
	li $t3, 1
	blt $t0, $t1, jmp_2
	li $t3, 0
jmp_2:
	sw $t3, -12($fp)
	lw $t0, -12($fp)
	bne $t0, $0, _temp_label_18
	lw $t0, -12($fp)
	beq $t0, $0, _temp_label_24
_temp_label_15:
	lw $t0, -104($fp)
	sw $t0, -16($fp)
	lw $t0, -104($fp)
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, -104($fp)
	j _temp_label_12
_temp_label_18:
	lw $t0, -100($fp)
	li $t1, 8
	mult $t0, $t1
	mflo $t0
	sw $t0, -20($fp)
	lw $t0, -20($fp)
	lw $t1, -104($fp)
	add $t2, $t0, $t1
	sw $t2, -20($fp)
	la $t5, -360($fp)
	lw $t6, -20($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -20($fp)
	li $t0, 1
	sw $t0, -20($fp)
	lw $t0, -20($fp)
	sw $t0, ($t5)
	j _temp_label_15
_temp_label_24:
	j _temp_label_8
_temp_label_25:
	li $t0, 2
	sw $t0, -100($fp)
_temp_label_26:
	lw $t0, -100($fp)
	li $t1, 8
	li $t3, 1
	blt $t0, $t1, jmp_3
	li $t3, 0
jmp_3:
	sw $t3, -24($fp)
	lw $t0, -24($fp)
	bne $t0, $0, _temp_label_32
	lw $t0, -24($fp)
	beq $t0, $0, _temp_label_55
_temp_label_29:
	lw $t0, -100($fp)
	sw $t0, -28($fp)
	lw $t0, -100($fp)
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, -100($fp)
	j _temp_label_26
_temp_label_32:
	li $t0, 1
	sw $t0, -104($fp)
_temp_label_33:
	lw $t0, -104($fp)
	lw $t1, -100($fp)
	li $t3, 1
	blt $t0, $t1, jmp_4
	li $t3, 0
jmp_4:
	sw $t3, -32($fp)
	lw $t0, -32($fp)
	bne $t0, $0, _temp_label_39
	lw $t0, -32($fp)
	beq $t0, $0, _temp_label_54
_temp_label_36:
	lw $t0, -104($fp)
	sw $t0, -36($fp)
	lw $t0, -104($fp)
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, -104($fp)
	j _temp_label_33
_temp_label_39:
	lw $t0, -104($fp)
	li $t1, 1
	sub $t2, $t0, $t1
	sw $t2, -40($fp)
	lw $t0, -100($fp)
	li $t1, 1
	sub $t2, $t0, $t1
	sw $t2, -44($fp)
	lw $t0, -44($fp)
	li $t1, 8
	mult $t0, $t1
	mflo $t0
	sw $t0, -48($fp)
	lw $t0, -48($fp)
	lw $t1, -40($fp)
	add $t2, $t0, $t1
	sw $t2, -48($fp)
	la $t5, -360($fp)
	lw $t6, -48($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -48($fp)
	lw $t0, -100($fp)
	li $t1, 1
	sub $t2, $t0, $t1
	sw $t2, -52($fp)
	lw $t0, -52($fp)
	li $t1, 8
	mult $t0, $t1
	mflo $t0
	sw $t0, -56($fp)
	lw $t0, -56($fp)
	lw $t1, -104($fp)
	add $t2, $t0, $t1
	sw $t2, -56($fp)
	la $t5, -360($fp)
	lw $t6, -56($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -56($fp)
	lw $t0, -100($fp)
	li $t1, 8
	mult $t0, $t1
	mflo $t0
	sw $t0, -60($fp)
	lw $t0, -60($fp)
	lw $t1, -104($fp)
	add $t2, $t0, $t1
	sw $t2, -60($fp)
	la $t5, -360($fp)
	lw $t6, -60($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -60($fp)
	lw $t0, -56($fp)
	lw $t1, -48($fp)
	add $t2, $t0, $t1
	sw $t2, -60($fp)
	lw $t0, -60($fp)
	sw $t0, ($t5)
	j _temp_label_36
_temp_label_54:
	j _temp_label_29
_temp_label_55:
	li $t0, 0
	sw $t0, -100($fp)
_temp_label_56:
	lw $t0, -100($fp)
	li $t1, 8
	li $t3, 1
	blt $t0, $t1, jmp_5
	li $t3, 0
jmp_5:
	sw $t3, -64($fp)
	lw $t0, -64($fp)
	bne $t0, $0, _temp_label_62
	lw $t0, -64($fp)
	beq $t0, $0, _temp_label_82
_temp_label_59:
	lw $t0, -100($fp)
	sw $t0, -68($fp)
	lw $t0, -100($fp)
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, -100($fp)
	j _temp_label_56
_temp_label_62:
	li $t0, 0
	sw $t0, -104($fp)
_temp_label_63:
	lw $t0, -104($fp)
	lw $t1, -100($fp)
	li $t3, 1
	ble $t0, $t1, jmp_6
	li $t3, 0
jmp_6:
	sw $t3, -72($fp)
	lw $t0, -72($fp)
	bne $t0, $0, _temp_label_69
	lw $t0, -72($fp)
	beq $t0, $0, _temp_label_77
_temp_label_66:
	lw $t0, -104($fp)
	sw $t0, -76($fp)
	lw $t0, -104($fp)
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, -104($fp)
	j _temp_label_63
_temp_label_69:
	lw $t0, -100($fp)
	li $t1, 8
	mult $t0, $t1
	mflo $t0
	sw $t0, -80($fp)
	lw $t0, -80($fp)
	lw $t1, -104($fp)
	add $t2, $t0, $t1
	sw $t2, -80($fp)
	la $t5, -360($fp)
	lw $t6, -80($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -80($fp)
	lw $t0, -80($fp)
	sw $t0, -84($fp)
	lw $a0, -84($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_PrintInt
	sw $v0, -88($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	j _temp_label_66
_temp_label_77:
	la $t0, _0sc
	sw $t0, -92($fp)
	lw $a0, -92($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_PrintStr
	sw $v0, -96($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	j _temp_label_59
_temp_label_82:
	j func_1_end
func_1_end:
	addu $sp, $sp, 264
	addu $sp, $sp, 96
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
	jal YangHuiTriangle
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

