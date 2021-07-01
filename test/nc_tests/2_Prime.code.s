.data
	n : .space 44
	res : .space 48
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
	subu $sp, $sp, 20
	sw $a0, -52($fp)
	li $t0, 0
	sw $t0, -56($fp)
	li $t0, 1
	sw $t0, -68($fp)
	li $t0, 2
	sw $t0, -60($fp)
_temp_label_10:
	lw $t0, -60($fp)
	lw $t1, -52($fp)
	li $t3, 1
	ble $t0, $t1, jmp_1
	li $t3, 0
jmp_1:
	sw $t3, -4($fp)
	lw $t0, -4($fp)
	bne $t0, $0, _temp_label_16
	lw $t0, -4($fp)
	beq $t0, $0, _temp_label_42
_temp_label_13:
	lw $t0, -60($fp)
	sw $t0, -8($fp)
	lw $t0, -60($fp)
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, -60($fp)
	j _temp_label_10
_temp_label_16:
	li $t0, 1
	sw $t0, -68($fp)
	li $t0, 2
	sw $t0, -64($fp)
_temp_label_18:
	lw $t0, -64($fp)
	lw $t1, -64($fp)
	mult $t0, $t1
	mflo $t0
	sw $t0, -12($fp)
	lw $t0, -12($fp)
	lw $t1, -60($fp)
	li $t3, 1
	ble $t0, $t1, jmp_2
	li $t3, 0
jmp_2:
	sw $t3, -16($fp)
	lw $t0, -16($fp)
	bne $t0, $0, _temp_label_25
	lw $t0, -16($fp)
	beq $t0, $0, _temp_label_32
_temp_label_22:
	lw $t0, -64($fp)
	sw $t0, -20($fp)
	lw $t0, -64($fp)
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, -64($fp)
	j _temp_label_18
_temp_label_25:
	lw $t0, -60($fp)
	lw $t1, -64($fp)
	div $t0, $t1
	mfhi $t0
	sw $t0, -24($fp)
	lw $t0, -24($fp)
	li $t1, 0
	li $t3, 1
	beq $t0, $t1, jmp_3
	li $t3, 0
jmp_3:
	sw $t3, -28($fp)
	lw $t0, -28($fp)
	beq $t0, $0, _temp_label_30
	li $t0, 0
	sw $t0, -68($fp)
	j _temp_label_32
_temp_label_30:
	j _temp_label_31
_temp_label_31:
	j _temp_label_22
_temp_label_32:
	lw $t0, -68($fp)
	li $t1, 1
	li $t3, 1
	beq $t0, $t1, jmp_4
	li $t3, 0
jmp_4:
	sw $t3, -32($fp)
	lw $t0, -32($fp)
	beq $t0, $0, _temp_label_40
	lw $t0, -56($fp)
	sw $t0, -36($fp)
	lw $t0, -56($fp)
	li $t1, 1
	add $t0, $t0, $t1
	sw $t0, -56($fp)
	lw $t0, -60($fp)
	sw $t0, -40($fp)
	lw $a0, -40($fp)
	subu $sp, $sp, 4
	sw $ra, ($sp)
	jal Mars_PrintInt
	sw $v0, -44($fp)
	lw $ra, ($sp)
	addu $sp, $sp, 4
_temp_label_40:
	j _temp_label_41
_temp_label_41:
	j _temp_label_13
_temp_label_42:
	lw $t0, -56($fp)
	sw $t0, -48($fp)
	lw $v0, -48($fp)
	j func_1_end
func_1_end:
	addu $sp, $sp, 20
	addu $sp, $sp, 48
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
	jal prime
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

