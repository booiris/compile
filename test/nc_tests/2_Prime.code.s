.data
	n : .space 4
	j : .space 4
	sum : .space 4
	i : .space 4
	flag : .space 4
	res : .space 4
	_1sc : .asciiz "The number of prime numbers within n is:\n"
	_0sc : .asciiz "Please input a number:\n"
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
prime:
	subu $sp, $sp, 4
	sw $fp, ($sp)
	move $fp, $sp
	subu $sp, $sp, 48
	li $t0, 0
	sw $t0, sum
	li $t0, 1
	sw $t0, flag
	li $t0, 2
	sw $t0, i
_temp_label_9:
	lw $t0, i
	lw $t1, n
	li $t3, 1
	ble $t0, $t1, jmp_1
	li $t3, 0
jmp_1:
	sw $t3, -4($fp)
	lw $t0, -4($fp)
	bne $t0, $0, _temp_label_15
	lw $t0, -4($fp)
	beq $t0, $0, _temp_label_41
_temp_label_12:
	lw $t0, i
	sw $t0, -8($fp)
	lw $t0, i
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, i
	j _temp_label_9
_temp_label_15:
	li $t0, 1
	sw $t0, flag
	li $t0, 2
	sw $t0, j
_temp_label_17:
	lw $t0, j
	lw $t1, j
	mult $t0, $t1
	mflo $t0
	sw $t0, -12($fp)
	lw $t0, -12($fp)
	lw $t1, i
	li $t3, 1
	ble $t0, $t1, jmp_2
	li $t3, 0
jmp_2:
	sw $t3, -16($fp)
	lw $t0, -16($fp)
	bne $t0, $0, _temp_label_24
	lw $t0, -16($fp)
	beq $t0, $0, _temp_label_31
_temp_label_21:
	lw $t0, j
	sw $t0, -20($fp)
	lw $t0, j
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, j
	j _temp_label_17
_temp_label_24:
	lw $t0, i
	lw $t1, j
	div $t0, $t1
	mfhi $t0
	sw $t0, -24($fp)
	lw $t0, -28($fp)
	bne $t0, $0, _temp_label_28
	j _temp_label_30
_temp_label_28:
	li $t0, 0
	sw $t0, flag
_temp_label_30:
	j _temp_label_21
_temp_label_31:
	lw $t0, -32($fp)
	bne $t0, $0, _temp_label_34
	j _temp_label_40
_temp_label_34:
	lw $t0, sum
	sw $t0, -36($fp)
	lw $t0, sum
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, sum
	lw $t0, i
	sw $t0, -40($fp)
	lw $a0, -40($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_PrintInt
	sw $v0, -44($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
_temp_label_40:
	j _temp_label_12
_temp_label_41:
	lw $t0, sum
	sw $t0, -48($fp)
	lw $v0, -48($fp)
	addu $sp, $sp, 48
	lw $fp, ($sp)
	addu $sp, $sp, 4
	jr $ra
main:
	subu $sp, $sp, 4
	sw $fp, ($sp)
	move $fp, $sp
	subu $sp, $sp, 40
	la $t0, _0sc
	sw $t0, -4($fp)
	lw $a0, -4($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_PrintStr
	sw $v0, -8($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_GetInt
	sw $v0, -12($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	lw $t0, -12($fp)
	sw $t0, n
	lw $t0, n
	sw $t0, -16($fp)
	lw $a0, -16($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal prime
	sw $v0, -20($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	lw $t0, -20($fp)
	sw $t0, res
	la $t0, _1sc
	sw $t0, -24($fp)
	lw $a0, -24($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_PrintStr
	sw $v0, -28($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	lw $t0, res
	sw $t0, -32($fp)
	lw $a0, -32($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_PrintInt
	sw $v0, -36($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	li $t0, 0
	sw $t0, -40($fp)
	lw $v0, -40($fp)
	addu $sp, $sp, 40
	lw $fp, ($sp)
	addu $sp, $sp, 4
	jr $ra

