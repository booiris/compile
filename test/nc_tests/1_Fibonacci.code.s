.data
	n : .space 4
	num : .space 4
	res : .space 4
	_1sc : .asciiz "This number's fibonacci value is :\n"
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
fibonacci:
	subu $sp, $sp, 4
	sw $fp, ($sp)
	move $fp, $sp
	subu $sp, $sp, 44
	subu $sp, $sp, 16
	subu $sp, $sp, 8
	sw $a0, num
	lw $t0, num
	li $t1, 1
	li $t3, 1
	blt $t0, $t1, jmp_1
	li $t3, 0
jmp_1:
	sw $t3, -4($fp)
	lw $t0, -4($fp)
	bne $t0, $0, _temp_label_8
	lw $t0, -4($fp)
	beq $t0, $0, _temp_label_12
	j _temp_label_31
_temp_label_8:
	li $t0, 0
	sw $t0, res
	lw $t0, res
	sw $t0, -8($fp)
	lw $v0, -8($fp)
	addu $sp, $sp, 8
	lw $fp, ($sp)
	addu $sp, $sp, 4
	jr $ra
_temp_label_12:
	lw $t0, num
	li $t1, 2
	li $t3, 1
	ble $t0, $t1, jmp_2
	li $t3, 0
jmp_2:
	sw $t3, -12($fp)
	lw $t0, -12($fp)
	bne $t0, $0, _temp_label_16
	lw $t0, -12($fp)
	beq $t0, $0, _temp_label_20
	j _temp_label_31
_temp_label_16:
	li $t0, 1
	sw $t0, res
	lw $t0, res
	sw $t0, -16($fp)
	lw $v0, -16($fp)
	addu $sp, $sp, 16
	lw $fp, ($sp)
	addu $sp, $sp, 4
	jr $ra
_temp_label_20:
	lw $t0, num
	li $t1, 2
	sub $t2, $t0, $t1
	sw $t2, -20($fp)
	lw $t0, -20($fp)
	sw $t0, -24($fp)
	lw $a0, -24($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal fibonacci
	sw $v0, -28($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	lw $t0, num
	li $t1, 1
	sub $t2, $t0, $t1
	sw $t2, -32($fp)
	lw $t0, -32($fp)
	sw $t0, -36($fp)
	lw $a0, -36($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal fibonacci
	sw $v0, -40($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	lw $t0, -40($fp)
	lw $t1, -28($fp)
	add $t2, $t0, $t1
	sw $t2, res
_temp_label_31:
	lw $t0, res
	sw $t0, -44($fp)
	lw $v0, -44($fp)
	addu $sp, $sp, 44
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
	jal fibonacci
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

