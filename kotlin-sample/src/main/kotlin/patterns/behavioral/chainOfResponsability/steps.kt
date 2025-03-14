import patterns.behavioral.chainofresponsibility.Request
import patterns.behavioral.chainofresponsibility.Response

typealias Handler = (request: Request) -> Response

val authentication =
        fun(next: Handler) =
                fun(request: Request): Response {
                    if (!request.isKnownEmail()) {
                        throw IllegalArgumentException("Unknown email")
                    }
                    return next(request)
                }

val basicValidation =
        fun(next: Handler) =
                fun(request: Request): Response {
                    if (request.email.isEmpty() || request.question.isEmpty()) {
                        throw IllegalArgumentException("Email or question is empty")
                    }
                    return next(request)
                }

val finalResponse = fun() =
    fun(_: Request): Response {
        return Response("I don't know")
    }
