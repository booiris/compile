.data
	n : .space 4
	i : .space 4
	count : .space 4
	num : .space 4
	c : .space 4
	s : .space 4
	p : .space 320
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
	li $t0, 0
	sw $t0, c
	li $t0, 2
	sw $t0, num
_temp_label_10:
	lw $t0, num
	lw $t1, n
	li $t3, 1
	blt $t0, $t1, jmp_1
	li $t3, 0
jmp_1:
	sw $t3, -4($fp)
	lw $t0, -4($fp)
	bne $t0, $0, _temp_label_16
	lw $t0, -4($fp)
	beq $t0, $0, _temp_label_48
_temp_label_13:
	lw $t0, num
	sw $t0, -8($fp)
	lw $t0, num
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, num
	j _temp_label_10
_temp_label_16:
	li $t0, 0
	sw $t0, count
	lw $t0, num
	sw $t0, s
	li $t0, 1
	sw $t0, i
_temp_label_19:
	lw $t0, num
	li $t1, 2
	div $t0, $t1
	mflo $t0
	sw $t0, -12($fp)
	lw $t0, -12($fp)
	li $t1, 1
	add $t2, $t0, $t1
	sw $t2, -16($fp)
	lw $t0, i
	lw $t1, -16($fp)
	li $t3, 1
	blt $t0, $t1, jmp_2
	li $t3, 0
jmp_2:
	sw $t3, -20($fp)
	lw $t0, -20($fp)
	bne $t0, $0, _temp_label_27
	lw $t0, -20($fp)
	beq $t0, $0, _temp_label_38
_temp_label_24:
	lw $t0, i
	sw $t0, -24($fp)
	lw $t0, i
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, i
	j _temp_label_19
_temp_label_27:
	lw $t0, num
	lw $t1, i
	div $t0, $t1
	mfhi $t0
	sw $t0, -28($fp)
	lw $t0, -32($fp)
	bne $t0, $0, _temp_label_31
	j _temp_label_37
_temp_label_31:
	lw $t0, count
	sw $t0, -40($fp)
	lw $t0, count
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, count
	la $t5, p
	lw $t6, -40($fp)
	li $t7, 4
	mult $t6, $t7
	mflo $t6
	add $t5, $t5, $t6
	lw $t6, ($t5)
	sw $t6, -36($fp)
	lw $t0, i
	sw $t0, -36($fp)
	lw $t0, -36($fp)
	sw $t0, ($t5)
	lw $t0, s
	lw $t1, i
	sub $t2, $t0, $t1
	sw $t2, s
_temp_label_37:
	j _temp_label_24
_temp_label_38:
	lw $t0, -44($fp)
	bne $t0, $0, _temp_label_41
	j _temp_label_47
_temp_label_41:
	lw $t0, num
	sw $t0, -48($fp)
	lw $a0, -48($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_PrintInt
	sw $v0, -52($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	lw $t0, c
	sw $t0, -56($fp)
	lw $t0, c
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, c
_temp_label_47:
	j _temp_label_13
_temp_label_48:
	la $t0, _0sc
	sw $t0, -60($fp)
	lw $a0, -60($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_PrintStr
	sw $v0, -64($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	lw $t0, c
	sw $t0, -68($fp)
	lw $a0, -68($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_PrintInt
	sw $v0, -72($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	addu $sp, $sp, 72
	lw $fp, ($sp)
	addu $sp, $sp, 4
	jr $ra
main:
	subu $sp, $sp, 4
	sw $fp, ($sp)
	move $fp, $sp
	subu $sp, $sp, 20
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
	addu $sp, $sp, 20
	lw $fp, ($sp)
	addu $sp, $sp, 4
	jr $ra

