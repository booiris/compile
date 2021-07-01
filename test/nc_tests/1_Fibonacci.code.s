.data
	n : .space 44
	res : .space 48
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
	subu $sp, $sp, 36
	subu $sp, $sp, 8
	sw $a0, -40($fp)
	lw $t0, -40($fp)
	li $t1, 1
	li $t3, 1
	blt $t0, $t1, jmp_1
	li $t3, 0
jmp_1:
	sw $t3, -4($fp)
	lw $t0, -4($fp)
	beq $t0, $0, _temp_label_8
	li $t0, 0
	sw $t0, -44($fp)
	j _temp_label_23
_temp_label_8:
	lw $t0, -40($fp)
	li $t1, 2
	li $t3, 1
	ble $t0, $t1, jmp_2
	li $t3, 0
jmp_2:
	sw $t3, -8($fp)
	lw $t0, -8($fp)
	beq $t0, $0, _temp_label_12
	li $t0, 1
	sw $t0, -44($fp)
	j _temp_label_23
_temp_label_12:
	lw $t0, -40($fp)
	li $t1, 2
	sub $t2, $t0, $t1
	sw $t2, -12($fp)
	lw $t0, -12($fp)
	sw $t0, -16($fp)
	lw $a0, -16($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal fibonacci
	sw $v0, -20($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	lw $t0, -40($fp)
	li $t1, 1
	sub $t2, $t0, $t1
	sw $t2, -24($fp)
	lw $t0, -24($fp)
	sw $t0, -28($fp)
	lw $a0, -28($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal fibonacci
	sw $v0, -32($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	lw $t0, -32($fp)
	lw $t1, -20($fp)
	add $t2, $t0, $t1
	sw $t2, -44($fp)
_temp_label_23:
	lw $t0, -44($fp)
	sw $t0, -36($fp)
	lw $v0, -36($fp)
	j func_1_end
func_1_end:
	addu $sp, $sp, 8
	addu $sp, $sp, 36
	lw $fp, ($sp)
	addu $sp, $sp, 4
	jr $ra
main:
	subu $sp, $sp, 4
	sw $fp, ($sp)
	move $fp, $sp
	subu $sp, $sp, 40
	subu $sp, $sp, 8
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
	sw $t0, -44($fp)
	lw $t0, -44($fp)
	sw $t0, -16($fp)
	lw $a0, -16($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal fibonacci
	sw $v0, -20($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	lw $t0, -20($fp)
	sw $t0, -48($fp)
	la $t0, _1sc
	sw $t0, -24($fp)
	lw $a0, -24($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_PrintStr
	sw $v0, -28($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
	lw $t0, -48($fp)
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
	j func_2_end
func_2_end:
	addu $sp, $sp, 8
	addu $sp, $sp, 40
	lw $fp, ($sp)
	addu $sp, $sp, 4
	jr $ra

