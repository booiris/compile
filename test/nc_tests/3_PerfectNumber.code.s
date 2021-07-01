.data
blank : .asciiz " "
_1sc : .asciiz "The sum is :\n"
_2sc : .asciiz "All perfect numbers within 100:\n"
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
	subu $sp, $sp, 364
	move $25, $4
	li $24, 0
	move $23, $24
	li $24, 2
	move $22, $24
_1LoopCheckLabel:
	slt $24, $22, $25
	move $21, $24
	beq $21, $0, _1LoopEndLabel
	li $24, 0
	move $21, $24
	move $24, $22
	li $20, 1
	move $19, $20
_2LoopCheckLabel:
	li $20, 2
	div $18, $22, $20
	move $20, $18
	li $18, 1
	add $17, $20, $18
	move $20, $17
	slt $18, $19, $20
	move $17, $18
	beq $17, $0, _2LoopEndLabel
	rem $17, $22, $19
	move $18, $17
	li $17, 0
	seq $20, $18, $17
	move $18, $20
	beq $18, $0, _1otherwise1
	move $18, $21
	li $20, 1
	add $21, $21, $20
	li $20, 0
	add $20, $20, $18
	mul $20, $20, 4
	li $18, 4
	add $20, $20, $18
	subu $v1, $fp, $20
	subu $v1, $v1, 4
	sw $19, ($v1)
	sub $18, $24, $19
	move $24, $18
	j _1endif
_1otherwise1:
_1endif:
_2LoopStepLabel:
	li $20, 1
	add $19, $19, $20
	j _2LoopCheckLabel
_2LoopEndLabel:
	li $21, 0
	seq $20, $21, $24
	move $21, $20
	beq $21, $0, _2otherwise1
	sw $23, -344($fp)
	sw $22, -332($fp)
	sw $25, -4($fp)
	subu $sp, $sp, 4
	sw $fp, ($sp)
	move $fp, $sp
	sw $31, 20($sp)
	move $4, $22
	jal Mars_PrintInt
	lw $31, 20($sp)
	lw $fp, ($sp)
	addu $sp, $sp, 4
	lw $23, -344($fp)
	lw $22, -332($fp)
	lw $25, -4($fp)
	li $21, 1
	add $23, $23, $21
	j _2endif
_2otherwise1:
_2endif:
_1LoopStepLabel:
	li $20, 1
	add $22, $22, $20
	j _1LoopCheckLabel
_1LoopEndLabel:
	la $25, _1sc
	sw $23, -344($fp)
	subu $sp, $sp, 4
	sw $fp, ($sp)
	move $fp, $sp
	sw $31, 20($sp)
	move $4, $25
	jal Mars_PrintStr
	lw $31, 20($sp)
	lw $fp, ($sp)
	addu $sp, $sp, 4
	lw $23, -344($fp)
	subu $sp, $sp, 4
	sw $fp, ($sp)
	move $fp, $sp
	sw $31, 20($sp)
	move $4, $23
	jal Mars_PrintInt
	lw $31, 20($sp)
	lw $fp, ($sp)
	addu $sp, $sp, 4
	move $sp, $fp
	jr $31
main:
	subu $sp, $sp, 20
	la $25, _2sc
	subu $sp, $sp, 4
	sw $fp, ($sp)
	move $fp, $sp
	sw $31, 20($sp)
	move $4, $25
	jal Mars_PrintStr
	lw $31, 20($sp)
	lw $fp, ($sp)
	addu $sp, $sp, 4
	li $25, 100
	subu $sp, $sp, 4
	sw $fp, ($sp)
	move $fp, $sp
	sw $31, 20($sp)
	move $4, $25
	jal perfectNumber
	lw $31, 20($sp)
	lw $fp, ($sp)
	addu $sp, $sp, 4
	li $25, 0
	move $2, $25
	move $sp, $fp
	jr $31
