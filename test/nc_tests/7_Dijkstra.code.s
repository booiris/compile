.data
maxint : .word 0
dist : .space 200
prev : .space 200
cc : .space 10000
n : .word 0
line : .word 0
blank : .asciiz " "
_4sc : .asciiz "\nThe path is:\n"
_3sc : .asciiz "Shortest path length from source point to last vertex:"
_2sc : .asciiz "\n"
_1sc : .asciiz "->"
.text
__init:
	lui $sp, 0x8000
	addi $sp, $sp, 0x0000
	move $fp, $sp
	add $gp, $gp, 0x8000
	li $8, 999999
	sw $8, 0($gp)
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
Dijkskra:
	subu $sp, $sp, 236
	move $25, $4
	move $24, $5
	li $23, 1
	move $22, $23
_1LoopCheckLabel:
	sle $23, $22, $25
	move $21, $23
	beq $21, $0, _1LoopEndLabel
	li $23, 0
	add $23, $23, $22
	mul $23, $23, 4
	li $21, 4
	add $23, $23, $21
	li $21, 0
	add $21, $21, $24
	mul $21, $21, 50
	add $21, $21, $22
	mul $21, $21, 4
	li $20, 404
	add $21, $21, $20
	add $21, $21, $gp
	lw $21, ($21)
	add $v1, $23, $gp
	sw $21, ($v1)
	li $21, 0
	add $21, $21, $22
	mul $21, $21, 4
	li $23, 8
	add $21, $21, $23
	li $23, 0
	subu $v1, $fp, $21
	subu $v1, $v1, 4
	sw $23, ($v1)
	li $21, 0
	add $21, $21, $22
	mul $21, $21, 4
	li $23, 4
	add $21, $21, $23
	add $21, $21, $gp
	lw $21, ($21)
	lw $23, 0($gp)
	seq $20, $21, $23
	move $21, $20
	beq $21, $0, _1otherwise1
	li $20, 0
	add $20, $20, $22
	mul $20, $20, 4
	li $21, 204
	add $20, $20, $21
	li $21, 0
	add $v1, $20, $gp
	sw $21, ($v1)
	j _1endif
_1otherwise1:
	li $20, 0
	add $20, $20, $22
	mul $20, $20, 4
	li $21, 204
	add $20, $20, $21
	add $v1, $20, $gp
	sw $24, ($v1)
_1endif:
_1LoopStepLabel:
	li $21, 1
	add $22, $22, $21
	j _1LoopCheckLabel
_1LoopEndLabel:
	li $22, 0
	add $22, $22, $24
	mul $22, $22, 4
	li $21, 4
	add $22, $22, $21
	li $21, 0
	add $v1, $22, $gp
	sw $21, ($v1)
	li $21, 0
	add $21, $21, $24
	mul $21, $21, 4
	li $22, 8
	add $21, $21, $22
	li $22, 1
	subu $v1, $fp, $21
	subu $v1, $v1, 4
	sw $22, ($v1)
	li $22, 2
	move $21, $22
_2LoopCheckLabel:
	sle $22, $21, $25
	move $20, $22
	beq $20, $0, _2LoopEndLabel
	lw $23, 0($gp)
	move $22, $23
	move $20, $24
	li $19, 1
	move $18, $19
_3LoopCheckLabel:
	sle $19, $18, $25
	move $17, $19
	beq $17, $0, _3LoopEndLabel
	li $19, 0
	add $19, $19, $18
	mul $19, $19, 4
	li $17, 8
	add $19, $19, $17
	subu $19, $fp, $19
	subu $19, $19, 4
	lw $19, ($19)
	seq $17, $19, $0
	beq $17, $0, _1shortwaytrue
	li $19, 0
	add $19, $19, $18
	mul $19, $19, 4
	li $16, 4
	add $19, $19, $16
	add $19, $19, $gp
	lw $19, ($19)
	slt $16, $19, $22
	move $19, $16
	sne $v1, $17, $0
	sne $16, $19, $0
	and $16, $16, $v1
	j _1shortwayfalse
_1shortwaytrue:
	li $17, 0
	j _1shortwayend
_1shortwayfalse:
	move $17, $16
_1shortwayend:
	beq $17, $0, _2otherwise1
	move $20, $18
	li $17, 0
	add $17, $17, $18
	mul $17, $17, 4
	li $16, 4
	add $17, $17, $16
	add $17, $17, $gp
	lw $17, ($17)
	move $22, $17
	j _2endif
_2otherwise1:
_2endif:
_3LoopStepLabel:
	li $16, 1
	add $18, $18, $16
	j _3LoopCheckLabel
_3LoopEndLabel:
	li $18, 0
	add $18, $18, $20
	mul $18, $18, 4
	li $16, 8
	add $18, $18, $16
	li $22, 1
	subu $v1, $fp, $18
	subu $v1, $v1, 4
	sw $22, ($v1)
	li $18, 1
	move $22, $18
_4LoopCheckLabel:
	sle $18, $22, $25
	move $16, $18
	beq $16, $0, _4LoopEndLabel
	li $18, 0
	add $18, $18, $22
	mul $18, $18, 4
	li $16, 8
	add $18, $18, $16
	subu $18, $fp, $18
	subu $18, $18, 4
	lw $18, ($18)
	seq $16, $18, $0
	beq $16, $0, _2shortwaytrue
	li $18, 0
	add $18, $18, $20
	mul $18, $18, 50
	add $18, $18, $22
	mul $18, $18, 4
	li $17, 404
	add $18, $18, $17
	add $18, $18, $gp
	lw $18, ($18)
	lw $23, 0($gp)
	slt $17, $18, $23
	move $18, $17
	sne $v1, $16, $0
	sne $23, $18, $0
	and $23, $23, $v1
	j _2shortwayfalse
_2shortwaytrue:
	li $18, 0
	j _2shortwayend
_2shortwayfalse:
	move $18, $23
_2shortwayend:
	beq $18, $0, _3otherwise1
	li $18, 0
	add $18, $18, $20
	mul $18, $18, 4
	li $23, 4
	add $18, $18, $23
	add $18, $18, $gp
	lw $18, ($18)
	li $23, 0
	add $23, $23, $20
	mul $23, $23, 50
	add $23, $23, $22
	mul $23, $23, 4
	li $16, 404
	add $23, $23, $16
	add $23, $23, $gp
	lw $23, ($23)
	add $16, $18, $23
	move $23, $16
	move $18, $23
	li $16, 0
	add $16, $16, $22
	mul $16, $16, 4
	li $23, 4
	add $16, $16, $23
	add $16, $16, $gp
	lw $16, ($16)
	slt $23, $18, $16
	move $16, $23
	beq $16, $0, _4otherwise1
	li $23, 0
	add $23, $23, $22
	mul $23, $23, 4
	li $16, 4
	add $23, $23, $16
	add $v1, $23, $gp
	sw $18, ($v1)
	li $23, 0
	add $23, $23, $22
	mul $23, $23, 4
	li $18, 204
	add $23, $23, $18
	add $v1, $23, $gp
	sw $20, ($v1)
	j _4endif
_4otherwise1:
_4endif:
	j _3endif
_3otherwise1:
_3endif:
_4LoopStepLabel:
	li $18, 1
	add $22, $22, $18
	j _4LoopCheckLabel
_4LoopEndLabel:
_2LoopStepLabel:
	li $20, 1
	add $21, $21, $20
	j _2LoopCheckLabel
_2LoopEndLabel:
	move $sp, $fp
	jr $31
searchPath:
	subu $sp, $sp, 240
	move $25, $4
	move $24, $5
	li $23, 1
	move $22, $23
	li $23, 0
	add $23, $23, $22
	mul $23, $23, 4
	li $21, 8
	add $23, $23, $21
	subu $v1, $fp, $23
	subu $v1, $v1, 4
	sw $24, ($v1)
	li $21, 1
	add $22, $22, $21
	li $23, 0
	add $23, $23, $24
	mul $23, $23, 4
	li $21, 204
	add $23, $23, $21
	add $23, $23, $gp
	lw $23, ($23)
	move $24, $23
_5LoopCheckLabel:
	sne $21, $24, $25
	move $23, $21
	beq $23, $0, _5LoopEndLabel
	li $21, 0
	add $21, $21, $22
	mul $21, $21, 4
	li $23, 8
	add $21, $21, $23
	subu $v1, $fp, $21
	subu $v1, $v1, 4
	sw $24, ($v1)
	li $23, 1
	add $22, $22, $23
	li $21, 0
	add $21, $21, $24
	mul $21, $21, 4
	li $23, 204
	add $21, $21, $23
	add $21, $21, $gp
	lw $21, ($21)
	move $24, $21
_5LoopStepLabel:
	j _5LoopCheckLabel
_5LoopEndLabel:
	li $24, 0
	add $24, $24, $22
	mul $24, $24, 4
	li $21, 8
	add $24, $24, $21
	subu $v1, $fp, $24
	subu $v1, $v1, 4
	sw $25, ($v1)
	move $24, $22
_6LoopCheckLabel:
	li $25, 1
	sge $22, $24, $25
	move $25, $22
	beq $25, $0, _6LoopEndLabel
	li $22, 0
	add $22, $22, $24
	mul $22, $22, 4
	li $25, 8
	add $22, $22, $25
	subu $22, $fp, $22
	subu $22, $22, 4
	lw $22, ($22)
	sw $24, -220($fp)
	subu $sp, $sp, 4
	sw $fp, ($sp)
	move $fp, $sp
	sw $31, 20($sp)
	move $4, $22
	jal Mars_PrintInt
	lw $31, 20($sp)
	lw $fp, ($sp)
	addu $sp, $sp, 4
	lw $24, -220($fp)
	li $25, 1
	sne $22, $24, $25
	move $25, $22
	beq $25, $0, _5otherwise1
	la $22, _1sc
	sw $24, -220($fp)
	subu $sp, $sp, 4
	sw $fp, ($sp)
	move $fp, $sp
	sw $31, 20($sp)
	move $4, $22
	jal Mars_PrintStr
	lw $31, 20($sp)
	lw $fp, ($sp)
	addu $sp, $sp, 4
	lw $24, -220($fp)
	j _5endif
_5otherwise1:
	la $25, _2sc
	sw $24, -220($fp)
	subu $sp, $sp, 4
	sw $fp, ($sp)
	move $fp, $sp
	sw $31, 20($sp)
	move $4, $25
	jal Mars_PrintStr
	lw $31, 20($sp)
	lw $fp, ($sp)
	addu $sp, $sp, 4
	lw $24, -220($fp)
_5endif:
_6LoopStepLabel:
	li $22, 1
	sub $24, $24, $22
	j _6LoopCheckLabel
_6LoopEndLabel:
	move $sp, $fp
	jr $31
main:
	subu $sp, $sp, 56
	subu $sp, $sp, 4
	sw $fp, ($sp)
	move $fp, $sp
	sw $31, 20($sp)
	jal Mars_GetInt
	lw $31, 20($sp)
	lw $fp, ($sp)
	addu $sp, $sp, 4
	move $25, $2
	move $24, $25
	sw $24, 10404($gp)
	subu $sp, $sp, 4
	sw $fp, ($sp)
	move $fp, $sp
	sw $31, 20($sp)
	jal Mars_GetInt
	lw $31, 20($sp)
	lw $fp, ($sp)
	addu $sp, $sp, 4
	move $25, $2
	move $23, $25
	sw $23, 10408($gp)
	li $25, 1
	move $22, $25
_7LoopCheckLabel:
	lw $24, 10404($gp)
	sle $25, $22, $24
	move $21, $25
	beq $21, $0, _7LoopEndLabel
	li $25, 1
	move $21, $25
_8LoopCheckLabel:
	lw $24, 10404($gp)
	sle $25, $21, $24
	move $20, $25
	beq $20, $0, _8LoopEndLabel
	li $25, 0
	add $25, $25, $22
	mul $25, $25, 50
	add $25, $25, $21
	mul $25, $25, 4
	li $20, 404
	add $25, $25, $20
	lw $20, 0($gp)
	add $v1, $25, $gp
	sw $20, ($v1)
_8LoopStepLabel:
	li $25, 1
	add $21, $21, $25
	j _8LoopCheckLabel
_8LoopEndLabel:
_7LoopStepLabel:
	li $25, 1
	add $22, $22, $25
	j _7LoopCheckLabel
_7LoopEndLabel:
	li $22, 1
	move $25, $22
_9LoopCheckLabel:
	lw $23, 10408($gp)
	sle $22, $25, $23
	move $23, $22
	beq $23, $0, _9LoopEndLabel
	sw $25, -24($fp)
	subu $sp, $sp, 4
	sw $fp, ($sp)
	move $fp, $sp
	sw $31, 20($sp)
	jal Mars_GetInt
	lw $31, 20($sp)
	lw $fp, ($sp)
	addu $sp, $sp, 4
	lw $25, -24($fp)
	move $22, $2
	move $23, $22
	sw $23, -4($fp)
	sw $25, -24($fp)
	subu $sp, $sp, 4
	sw $fp, ($sp)
	move $fp, $sp
	sw $31, 20($sp)
	jal Mars_GetInt
	lw $31, 20($sp)
	lw $fp, ($sp)
	addu $sp, $sp, 4
	lw $23, -4($fp)
	lw $25, -24($fp)
	move $22, $2
	move $21, $22
	sw $21, -8($fp)
	sw $23, -4($fp)
	sw $25, -24($fp)
	subu $sp, $sp, 4
	sw $fp, ($sp)
	move $fp, $sp
	sw $31, 20($sp)
	jal Mars_GetInt
	lw $31, 20($sp)
	lw $fp, ($sp)
	addu $sp, $sp, 4
	lw $21, -8($fp)
	lw $23, -4($fp)
	lw $25, -24($fp)
	move $22, $2
	move $19, $22
	li $22, 0
	add $22, $22, $23
	mul $22, $22, 50
	add $22, $22, $21
	mul $22, $22, 4
	li $18, 404
	add $22, $22, $18
	add $22, $22, $gp
	lw $22, ($22)
	slt $18, $19, $22
	move $22, $18
	beq $22, $0, _6otherwise1
	li $18, 0
	add $18, $18, $23
	mul $18, $18, 50
	add $18, $18, $21
	mul $18, $18, 4
	li $22, 404
	add $18, $18, $22
	add $v1, $18, $gp
	sw $19, ($v1)
	li $22, 0
	add $22, $22, $21
	mul $22, $22, 50
	add $22, $22, $23
	mul $22, $22, 4
	li $23, 404
	add $22, $22, $23
	add $v1, $22, $gp
	sw $19, ($v1)
	j _6endif
_6otherwise1:
_6endif:
_9LoopStepLabel:
	li $19, 1
	add $25, $25, $19
	j _9LoopCheckLabel
_9LoopEndLabel:
	li $19, 1
	move $22, $19
_10LoopCheckLabel:
	lw $24, 10404($gp)
	sle $25, $22, $24
	move $19, $25
	beq $19, $0, _10LoopEndLabel
	li $25, 0
	add $25, $25, $22
	mul $25, $25, 4
	li $19, 4
	add $25, $25, $19
	lw $20, 0($gp)
	add $v1, $25, $gp
	sw $20, ($v1)
_10LoopStepLabel:
	li $25, 1
	add $22, $22, $25
	j _10LoopCheckLabel
_10LoopEndLabel:
	li $22, 1
	move $25, $22
_11LoopCheckLabel:
	lw $24, 10404($gp)
	sle $22, $25, $24
	move $20, $22
	beq $20, $0, _11LoopEndLabel
	li $22, 1
	move $20, $22
_12LoopCheckLabel:
	lw $24, 10404($gp)
	sle $22, $20, $24
	move $19, $22
	beq $19, $0, _12LoopEndLabel
	li $22, 0
	add $22, $22, $25
	mul $22, $22, 50
	add $22, $22, $20
	mul $22, $22, 4
	li $19, 404
	add $22, $22, $19
	add $22, $22, $gp
	lw $22, ($22)
	sw $20, -36($fp)
	sw $25, -32($fp)
	subu $sp, $sp, 4
	sw $fp, ($sp)
	move $fp, $sp
	sw $31, 20($sp)
	move $4, $22
	jal Mars_PrintInt
	lw $31, 20($sp)
	lw $fp, ($sp)
	addu $sp, $sp, 4
	lw $20, -36($fp)
	lw $25, -32($fp)
_12LoopStepLabel:
	li $19, 1
	add $20, $20, $19
	j _12LoopCheckLabel
_12LoopEndLabel:
	la $20, _2sc
	sw $25, -32($fp)
	subu $sp, $sp, 4
	sw $fp, ($sp)
	move $fp, $sp
	sw $31, 20($sp)
	move $4, $20
	jal Mars_PrintStr
	lw $31, 20($sp)
	lw $fp, ($sp)
	addu $sp, $sp, 4
	lw $25, -32($fp)
_11LoopStepLabel:
	li $19, 1
	add $25, $25, $19
	j _11LoopCheckLabel
_11LoopEndLabel:
	lw $24, 10404($gp)
	li $25, 1
	subu $sp, $sp, 4
	sw $fp, ($sp)
	move $fp, $sp
	sw $31, 20($sp)
	move $4, $24
	move $5, $25
	jal Dijkskra
	lw $31, 20($sp)
	lw $fp, ($sp)
	addu $sp, $sp, 4
	la $19, _3sc
	subu $sp, $sp, 4
	sw $fp, ($sp)
	move $fp, $sp
	sw $31, 20($sp)
	move $4, $19
	jal Mars_PrintStr
	lw $31, 20($sp)
	lw $fp, ($sp)
	addu $sp, $sp, 4
	lw $24, 10404($gp)
	li $25, 0
	add $25, $25, $24
	mul $25, $25, 4
	li $19, 4
	add $25, $25, $19
	add $25, $25, $gp
	lw $25, ($25)
	subu $sp, $sp, 4
	sw $fp, ($sp)
	move $fp, $sp
	sw $31, 20($sp)
	move $4, $25
	jal Mars_PrintInt
	lw $31, 20($sp)
	lw $fp, ($sp)
	addu $sp, $sp, 4
	la $19, _4sc
	subu $sp, $sp, 4
	sw $fp, ($sp)
	move $fp, $sp
	sw $31, 20($sp)
	move $4, $19
	jal Mars_PrintStr
	lw $31, 20($sp)
	lw $fp, ($sp)
	addu $sp, $sp, 4
	li $25, 1
	lw $24, 10404($gp)
	subu $sp, $sp, 4
	sw $fp, ($sp)
	move $fp, $sp
	sw $31, 20($sp)
	move $4, $25
	move $5, $24
	jal searchPath
	lw $31, 20($sp)
	lw $fp, ($sp)
	addu $sp, $sp, 4
	li $24, 0
	move $2, $24
	move $sp, $fp
	jr $31
