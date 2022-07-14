# StegHide-image-stegnography-using-java

StegHide is java based standalone application used to perform Least significant bit (LSB) based image stegnography and image encryption 

# stegnography

Steganography is the process of hiding a secret message within a larger one in such a way that someone cannot know the presence or contents of the hidden message. Although related, Steganography is not to be confused with Encryption, which is the process of making a message unintelligible—Steganography attempts to hide the existence of communication. The main advantage of steganography algorithm is because of its simple security mechanism. Because the steganographic message is integrated invisibly and covered inside other harmless sources, it is very difficult to detect the message without knowing the existence and the appropriate encoding scheme .

# LSB(Least Significant Bit) Embedding
The LSB is the lowest significant bit in the byte value of the image pixel. The LSB based image steganography embeds the secret in the least significant bits of pixel values of the cover image (CVR). The concept of LSB Embedding is simple. It exploits the fact that the level of precision in many image formats is far greater than that perceivable by average human vision. Therefore, an altered image with slight variations in its colors will be indistinguishable from the original by a human being, just by looking at it. In conventional LSB technique, which requires eight bytes of pixels to store 1byte of secret data but in proposed LSB technique, just four bytes of pixels are sufficient to hold one message byte. Rest of the bits in the pixels remains the same. Following shows the bit level interpretation of the algorithm :


# Software Preview



![stehhide1](https://user-images.githubusercontent.com/109088129/178926106-eac68d1b-0126-40db-b604-a8bd6f872fe2.png)



![steghide2](https://user-images.githubusercontent.com/109088129/178926393-e6388202-759c-4104-ad92-d18c9dffab51.png)
