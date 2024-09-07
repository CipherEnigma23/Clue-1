import openai

    openai.api_key = "<ENTER RETRIEVED OPENAI API>"

    completion = openai.ChatCompletion.create(
        model="gpt-3.5-turbo",
        messages=[
            {"role": "user", "content": f"<ENTER WHAT YOU NEED>"}
        ]
    )

    return completion.choices[0].message['content']
