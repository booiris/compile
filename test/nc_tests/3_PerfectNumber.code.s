.data
	_1sc : .asciiz "All perfect numbers within 100:\n"
	_0sc : .asciiz "The sum is :\n"
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
perfectNumber:
	subu $sp, $sp, 4
	sw $fp, ($sp)
	move $fp, $sp
	subu $sp, $sp, 72
	subu $sp, $sp, 344
	sw $a0, -76($fp)
	li $t0, 0
	sw $t0, -416($fp)
	li $t0, 2
	sw $t0, -404($fp)
_temp_label_11:
	lw $t0, -404($fp)
	lw $t1, -76($fp)
	li $t3, 1
	blt $t0, $t1, jmp_1
	li $t3, 0
jmp_1:
	sw $t3, -4($fp)
	lw $t0, -4($fp)
	bne $t0, $0, _temp_label_17
	lw $t0, -4($fp)
	beq $t0, $0, _temp_label_49
_temp_label_14:
	lw $t0, -404($fp)
	sw $t0, -8($fp)
	lw $t0, -404($fp)
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, -404($fp)
	j _temp_label_11
_temp_label_17:
	li $t0, 0
	sw $t0, -408($fp)
	lw $t0, -404($fp)
	sw $t0, -412($fp)
	li $t0, 1
	sw $t0, -400($fp)
_temp_label_20:
	lw $t0, -404($fp)
	li $t1, 2
	div $t0, $t1
	mflo $t0
	sw $t0, -12($fp)
	lw $t0, -12($fp)
	li $t1, 1
	add $t2, $t0, $t1
	sw $t2, -16($fp)
	lw $t0, -400($fp)
	lw $t1, -16($fp)
	li $t3, 1
	blt $t0, $t1, jmp_2
	li $t3, 0
jmp_2:
	sw $t3, -20($fp)
	lw $t0, -20($fp)
	bne $t0, $0, _temp_label_28
	lw $t0, -20($fp)
	beq $t0, $0, _temp_label_39
_temp_label_25:
	lw $t0, -400($fp)
	sw $t0, -24($fp)
	lw $t0, -400($fp)
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, -400($fp)
	j _temp_label_20
_temp_label_28:
	lw $t0, -404($fp)
	lw $t1, -400($fp)
	div $t0, $t1
	mfhi $t0
	sw $t0, -28($fp)
	lw $t0, -28($fp)
	li $t1, 0
	li $t3, 1
	beq $t0, $t1, jmp_3
	li $t3, 0
jmp_3:
	sw $t3, -32($fp)
	lw $t0, -32($fp)
	beq $t0, $0, _temp_label_37
	lw $t0, -408($fp)
	sw $t0, -36($fp)
	lw $t0, -408($fp)
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, -408($fp)
	la $t5, -396($fp)
	lw $t6, -36($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -40($fp)
	lw $t0, -400($fp)
	sw $t0, -40($fp)
	lw $t0, -40($fp)
	sw $t0, ($t5)
	lw $t0, -412($fp)
	lw $t1, -400($fp)
	sub $t2, $t0, $t1
	sw $t2, -412($fp)
_temp_label_37:
	j _temp_label_38
_temp_label_38:
	j _temp_label_25
_temp_label_39:
	li $t0, 0
	lw $t1, -412($fp)
	li $t3, 1
	beq $t0, $t1, jmp_4
	li $t3, 0
jmp_4:
	sw $t3, -44($fp)
	lw $t0, -44($fp)
	beq $t0, $0, _temp_label_47
	lw $t0, -404($fp)
	sw $t0, -48($fp)
	lw $a0, -48($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_PrintInt
	sw $v0, -52($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	lw $t0, -416($fp)
	sw $t0, -56($fp)
	lw $t0, -416($fp)
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, -416($fp)
_temp_label_47:
	j _temp_label_48
_temp_label_48:
	j _temp_label_14
_temp_label_49:
	la $t0, _0sc
	sw $t0, -60($fp)
	lw $a0, -60($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_PrintStr
	sw $v0, -64($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	lw $t0, -416($fp)
	sw $t0, -68($fp)
	lw $a0, -68($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_PrintInt
	sw $v0, -72($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	j func_1_end
func_1_end:
	addu $sp, $sp, 344
	addu $sp, $sp, 72
	lw $fp, ($sp)
	addu $sp, $sp, 4
	jr $ra
main:
	subu $sp, $sp, 4
	sw $fp, ($sp)
	move $fp, $sp
	subu $sp, $sp, 20
	subu $sp, $sp, 0
	la $t0, _1sc
	sw $t0, -4($fp)
	lw $a0, -4($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_PrintStr
	sw $v0, -8($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	li $t0, 100
	sw $t0, -12($fp)
	lw $a0, -12($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal perfectNumber
	sw $v0, -16($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	li $t0, 0
	sw $t0, -20($fp)
	lw $v0, -20($fp)
	j func_2_end
func_2_end:
	addu $sp, $sp, 0
	addu $sp, $sp, 20
	lw $fp, ($sp)
	addu $sp, $sp, 4
	jr $ra

