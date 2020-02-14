package com.astashin.bookvoed.network.response

import com.astashin.bookvoed.entity.Jwt
import com.astashin.bookvoed.entity.User

class LoginRegistrationResponse(val user: User, val jwt: Jwt)